package controller;

import common.BirthdayException;
import common.EmailException;
import common.PhoneException;
import common.Validate;
import model.Customer;
import model.CustomerType;
import repository.CustomerRepository;
import repository.CustomerRepositoryImpl;
import repository.CustomerTypeRepository;
import repository.CustomerTypeRepositoryImpl;

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

    CustomerRepository customerRepository = new CustomerRepositoryImpl();
    CustomerTypeRepository customerTypeRepository = new CustomerTypeRepositoryImpl();
    Validate validate = new Validate();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
            switch (action) {
                case "create":
                    try {
                        insertUser(request, response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "edit":
                    try {
                        updateUser(request, response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
            }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        CustomerType typeId = customerTypeRepository.selectTypeCustomerById(Integer.parseInt(request.getParameter("typeId")));
        String name = request.getParameter("name");
        String birthDay = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        customerRepository.updateCustomer(new Customer(id, typeId,name,birthDay,gender,idCard,phone,email,address));
        listUser(request,response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        boolean check = true;
        String messagePhone= null;
        String messageBirthDay = null;
        String messageEmail = null;
        String birthDay = null;
        String phone = null;
        String email = null;

        CustomerType customerType = customerTypeRepository.selectTypeCustomerById(Integer.parseInt(request.getParameter("typeId")));
        String name = request.getParameter("name");

        try {
            birthDay = request.getParameter("birthday");
            validate.regexDate(birthDay);
        } catch (BirthdayException e) {
            messageBirthDay = e.getMessage();
            check = false;
        }

        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");

        try {
            phone = request.getParameter("phone");
            validate.regexPhone(phone);
        } catch (PhoneException e) {
            messagePhone = e.getMessage();
            check = false;
        }

        try {
            email = request.getParameter("email");
            validate.regexEmail(email);
        } catch (EmailException e) {
            messageEmail = e.getMessage();
            check = false;
        }

        String address = request.getParameter("address");

        if (!check){
            request.setAttribute("typeId", customerType);
            request.setAttribute("name", name);
            request.setAttribute("birthday",birthDay);
            request.setAttribute("gender",gender);
            request.setAttribute("idCard",idCard);
            request.setAttribute("phone",phone);
            request.setAttribute("email",email);
            request.setAttribute("address",address);
            request.setAttribute("messageBirthDay",messageBirthDay);
            request.setAttribute("messagePhone",messagePhone);
            request.setAttribute("messageEmail",messageEmail);
            showNewForm(request,response);
        }else {
            customerRepository.insertCustomer(new Customer(customerType,name,birthDay,gender,idCard,phone,email,address));
            listUser(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "search":
                    try {
                        searchUser(request, response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "delete":
                    try {
                        deleteUser(request, response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    listUser(request, response);
                    break;
            }
    }

    private void searchUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("customerName");
        List<Customer> customerList = customerRepository.searchCustomer(name);
        request.setAttribute("customerList" ,customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request,response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerRepository.deleteCustomer(id);
        listUser(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerRepository.selectCustomerById(customerId);
        List<CustomerType> customerTypeList = customerTypeRepository.selectAllTypeCustomer();
        request.setAttribute("typeId", customerTypeList);
        request.setAttribute("name", customer.getCustomerName());
        request.setAttribute("birthday",customer.getCustomerBirthday());
        request.setAttribute("gender",customer.getCustomerBirthday());
        request.setAttribute("idCard",customer.getCustomerIdCard());
        request.setAttribute("phone",customer.getCustomerPhone());
        request.setAttribute("email",customer.getCustomerEmail());
        request.setAttribute("address",customer.getCustomerAddress());
        showNewForm(request,response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerType> customerTypeList = customerTypeRepository.selectAllTypeCustomer();
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerRepository.selectAllCustomer();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request, response);
    }
}
