package controller;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import common.Validate;
import model.BenhAn;
import model.BenhNhan;
import repository.BenhAnRepository;
import repository.BenhAnRepositoryImpl;
import repository.BenhNhanRepository;
import repository.BenhNhanRepositoryImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BenhAnServlet", urlPatterns = "/benh_an")
public class BenhAnServlet extends HttpServlet {

        BenhAnRepository benhAnRepository = new BenhAnRepositoryImpl();
        BenhNhanRepository benhNhanRepository = new BenhNhanRepositoryImpl();
        Validate validate = new Validate();

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            MysqlxDatatypes.Scalar.String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "create":
//                    try {
//                        insertUser(request, response);
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    }
//                    break;
//                case "edit":
//                    try {
//                        updateUser(request, response);
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    }
//                    break;
            }
        }

//        private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
//            int id = Integer.parseInt(request.getParameter("id"));
//            CustomerType typeId = customerTypeRepository.selectTypeCustomerById(Integer.parseInt(request.getParameter("typeId")));
//            String name = request.getParameter("name");
//            String birthDay = request.getParameter("birthday");
//            String gender = request.getParameter("gender");
//            String idCard = request.getParameter("idCard");
//            String phone = request.getParameter("phone");
//            String email = request.getParameter("email");
//            String address = request.getParameter("address");
//            customerRepository.updateCustomer(new Customer(id, typeId,name,birthDay,gender,idCard,phone,email,address));
//            listUser(request,response);
//        }
//
//        private void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
//            boolean check = true;
//            String messagePhone= null;
//            String messageBirthDay = null;
//            String messageEmail = null;
//            String birthDay = null;
//            String phone = null;
//            String email = null;
//
//            B customerType = customerTypeRepository.selectTypeCustomerById(Integer.parseInt(request.getParameter("typeId")));
//            String name = request.getParameter("name");
//
//            try {
//                birthDay = request.getParameter("birthday");
//                validate.regexDate(birthDay);
//            } catch (BirthdayException e) {
//                messageBirthDay = e.getMessage();
//                check = false;
//            }
//
//            String gender = request.getParameter("gender");
//            String idCard = request.getParameter("idCard");
//
//            try {
//                phone = request.getParameter("phone");
//                validate.regexPhone(phone);
//            } catch (PhoneException e) {
//                messagePhone = e.getMessage();
//                check = false;
//            }
//
//            try {
//                email = request.getParameter("email");
//                validate.regexEmail(email);
//            } catch (EmailException e) {
//                messageEmail = e.getMessage();
//                check = false;
//            }
//
//            String address = request.getParameter("address");
//
//            if (!check){
//                request.setAttribute("typeId", customerType);
//                request.setAttribute("name", name);
//                request.setAttribute("birthday",birthDay);
//                request.setAttribute("gender",gender);
//                request.setAttribute("idCard",idCard);
//                request.setAttribute("phone",phone);
//                request.setAttribute("email",email);
//                request.setAttribute("address",address);
//                request.setAttribute("messageBirthDay",messageBirthDay);
//                request.setAttribute("messagePhone",messagePhone);
//                request.setAttribute("messageEmail",messageEmail);
//                showNewForm(request,response);
//            }else {
//                customerRepository.insertCustomer(new Customer(customerType,name,birthDay,gender,idCard,phone,email,address));
//                listUser(request,response);
//            }
//        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }

            switch (action) {
//                case "create":
//                    showNewForm(request, response);
//                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
//                case "search":
//                    try {
//                        searchUser(request, response);
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    }
//                    break;
                case "delete":
                    try {
                        deleteUser(request, response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    listBenhAn(request, response);
                    break;
            }
        }

        private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            benhAnRepository.deleteBenhAn(id);
            listBenhAn(request,response);
        }

        private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            BenhAn benhAn = benhAnRepository.selectBenhAnById(id);
           BenhNhan benhNhan = benhNhanRepository.selectBenhNhanById(benhAn.getId());
            request.setAttribute("benh_nhan", benhNhan.getName());
            request.setAttribute("ngay_nhap_vien", benhAn.getNgayNhapVien());
            request.setAttribute("ngay_ra_vien",benhAn.getNgayRaVien());
            request.setAttribute("ly_do_nhap_vien",benhAn.getLyDoNhapVien());

            RequestDispatcher dispatcher = request.getRequestDispatcher("benh_an/edit.jsp");
            dispatcher.forward(request, response);
        }


        private void listBenhAn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            List<BenhAn> benhAnList = benhAnRepository.selectAllBenhAn();
            request.setAttribute("benhAnList", benhAnList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("benh_an/list.jsp");
            dispatcher.forward(request, response);
        }

}
