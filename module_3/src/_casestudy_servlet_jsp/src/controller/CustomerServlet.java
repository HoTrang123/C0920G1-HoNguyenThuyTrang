package controller;

import common.BirthdayException;
import common.EmailException;
import common.PhoneException;
import common.Validate;
import model.customer.Customer;
import model.customer.CustomerType;
import service.customer.CustomerService;
import service.customer.CustomerServiceImpl;
import service.customer.CustomerTypeService;
import service.customer.CustomerTypeServiceImpl;

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

    CustomerService customerService = new CustomerServiceImpl();
    CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();
    Validate validate = new Validate();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = " ";
        }
//        try {
            switch (action) {
                case "create":
                    try {
                        createCustomer(request,response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
//                case "search":
//                    break;
                case "edit":
                    try {
                        editCustomer(request,response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        int id = Integer.parseInt(request.getParameter("customerId"));
//        String typeId = request.getParameter("typeId");
        CustomerType typeId = customerTypeService.selectTypeCustomerById(Integer.parseInt(request.getParameter("typeId")));
        String name = request.getParameter("customerName");
        String birthDay = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        customerService.updateCustomer(new Customer(id, typeId,name,birthDay,gender,idCard,phone,email,address));
        request.setAttribute("messageConfig","đã sửa thành công");
//        response.sendRedirect("/customers");
        listCustomer(request,response);
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        boolean check = true;
        String messagePhone= null;
        String messageBirthDay = null;
        String messageEmail = null;
        String birthDay = null;
        String phone = null;
        String email = null;


//        String typeID = request.getParameter("typeId");
        CustomerType typeID = customerTypeService.selectTypeCustomerById(Integer.parseInt(request.getParameter("typeId")));
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
            request.setAttribute("typeId", typeID);
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
            showCreateCustomer(request,response);
        }else {
            customerService.insertCustomer(new Customer(typeID,name,birthDay,gender,idCard,phone,email,address));
            request.setAttribute("messageConfig","đã thêm thành công");
//        response.sendRedirect("/customers");
            listCustomer(request,response);
        }
        customerService.insertCustomer(new Customer(typeID,name,birthDay,gender,idCard,phone,email,address));
        request.setAttribute("messageConfig","đã thêm thành công");
//        response.sendRedirect("/customers");
        listCustomer(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = " ";
        }
//        try {
            switch (action) {
                case "create":
                    showCreateCustomer(request,response);
                    break;
                case "search":
                    try {
                        searchCustomerByname(request,response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "edit":
                    try {
                        showEditCustomer(request,response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "delete":
                    try {
                        deleteCustomer(request,response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    listCustomer(request, response);
                    break;
            }

//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    private void searchCustomerByname(HttpServletRequest request, HttpServletResponse response)  throws SQLException, IOException, ServletException{
        String name = request.getParameter("customerName");
        List<Customer> customerList = customerService.searchByName(name);
        request.setAttribute("customerList" ,customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request,response);
    }

    private void showEditCustomer(HttpServletRequest request, HttpServletResponse response)  throws SQLException, IOException, ServletException {
        int customerId = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.selectCustomerById(customerId);
        List<CustomerType> customerTypeList = customerTypeService.getAllCustomerType();
        request.setAttribute("customer",customer);
        request.setAttribute("customerType",customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        dispatcher.forward(request,response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)  throws SQLException, IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("customerId"));
        customerService.deleteCustomer(id);
        request.setAttribute("messageConfig","đã xóa thành công");
//        response.sendRedirect("/customers");
        listCustomer(request,response);
    }

    private void showCreateCustomer(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        List<CustomerType> customerTypeList = customerTypeService.getAllCustomerType();
        request.setAttribute("customerTypeList",customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        dispatcher.forward(request,response);
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerService.getAllCustomers();
        request.setAttribute("customerList",customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request,response);
    }
}
