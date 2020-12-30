<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/29/2020
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Benh An Management Application</title>
</head>
<body>
<center>
    <h1>Benh An Management</h1>
<%--    <h2>--%>
<%--        <a href="customers">List All Customer</a>--%>
<%--    </h2>--%>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Sua Benh An</h2>
            </caption>
            <tr>
                <th>Ten Benh Nhan:</th>
                <td>
                        <input value="${benh_nhan}" type="text" name="name" id="name" size="45" required/>

                </td>
            </tr>
            <tr>
                <th>Ngay nhap vien:</th>
                <td>
                    <input value="${ngay_nhap_vien}" type="date" name="nhap_vien" id="nhap_vien" size="45" required/>
                </td>
            </tr>
            <tr>
                <th>Ngay ra vien:</th>
                <td>
                    <input value="${ngay_ra_vien}" type="date" name="ra_vien" id="ra_vien" size="45" required/>

                </td>
            </tr>
            <tr>
                <th>Ly do nhap vien:</th>
                <td>
                    <input value="${ly_do_nhap_vien}" type="text" name="lu_do" id="ly_do" size="45" required />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" name="action" value="create"/>            </tr>
        </table>
    </form>
</div>
</body>
</html>