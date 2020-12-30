package controller;

import model.Contract;
import model.customer.Customer;
import model.employee.Employee;
import model.service.Service;
import service.contract.ContractService;
import service.contract.ContractServiceImpl;
import service.customer.CustomerService;
import service.customer.CustomerServiceImpl;
import service.employee.EmployeeService;
import service.employee.EmployeeServiceImpl;
import service.service.ServiceI;
import service.service.ServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = "/contracts")
public class ContractServlet extends HttpServlet {
    ContractService contractService = new ContractServiceImpl();
    CustomerService customerService = new CustomerServiceImpl();
    EmployeeService employeeService = new EmployeeServiceImpl();
    ServiceI serviceSe = new ServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = " ";
        }
        try {
            switch (action) {
                case "create":
                    createContract(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private void createContract(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(contractService.getAll().get(contractService.getAll().size() - 1).getId()) + 1;
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String deposit = request.getParameter("deposit");
        String totalMoney = request.getParameter("totalMoney");
        String employeeId = request.getParameter("employeeId");
        String customerId = request.getParameter("customerId");
        String serviceId = request.getParameter("serviceId");
        contractService.insert(new Contract(String.valueOf(id), startDate, endDate, deposit, totalMoney, employeeId, customerId, serviceId));
        response.sendRedirect("/contracts");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = " ";
        }

        switch (action) {
            case "create":
                showCreatContract(request, response);
                break;
            default:
                listContract(request, response);
                break;
        }


    }

    private void showCreatContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerService.getAllCustomers();
        List<Employee> employeeList = employeeService.getAllEmployees();
        List<Service> serviceList = serviceSe.getAll();
        request.setAttribute("customerList", customerList);
        request.setAttribute("employeeList", employeeList);
        request.setAttribute("serviceList", serviceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/create.jsp");
        dispatcher.forward(request, response);
    }

    private void listContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Contract> contractList = contractService.getAll();
        request.setAttribute("contractList", contractList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/list.jsp");
        dispatcher.forward(request, response);
    }

}