package controller;

import model.Customer;
import model.CustomerType;
import repo.CustomerRepository;
import repo.CustomerRepositoryImpl;
import repo.CustomerTypeRepository;
import repo.CustomerTypeRepositoryImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {

    CustomerTypeRepositoryImpl customerTypeRepository = new CustomerTypeRepositoryImpl();
    CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = " ";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "search":
                break;
            case "edit":
                break;
            case "delete":
                break;
            default:
                listCustomer(request, response);
                break;
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
            String customerId = request.getParameter("customerId");
            String typeID = request.getParameter("typeId");
            String name = request.getParameter("name");
            String birthDay = request.getParameter("birthday");
            String gender = request.getParameter("gender");
            String idCard = request.getParameter("idCard");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            Customer customer = new Customer(customerId,typeID,name,birthDay,gender,idCard,phone,email,address);
        try {
            customerRepository.insertCustomer(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            response.sendRedirect("/customers");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = " ";
        }
        switch (action) {
            case "create":
                    showCreateCustomer(request,response);
                break;
            case "search": {
                break;
            }
            case "edit":
                break;
            case "delete":
//                    deleteCustomer(request,response);
                break;
            default:
                listCustomer(request, response);
                break;
        }

    }

    private void showCreateCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = customerTypeRepository.getAllCustomerType();
        request.setAttribute("customerTypeList",customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerRepository.getAllCustomers();
        request.setAttribute("customerList",customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
