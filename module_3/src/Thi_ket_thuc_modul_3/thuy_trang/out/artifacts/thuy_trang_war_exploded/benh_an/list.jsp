<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/29/2020
  Time: 10:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>BENH AN Management Application</title>
</head>
<body>
<center>
    <h1>Benh An Management</h1>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Benh An</h2></caption>
        <tr>
            <th>ID benh an</th>
            <th>ID benh nhan</th>
            <th>Ten benh nhan</th>
            <th>Ngay nhap vien</th>
            <th>Ngay ra vien</th>
            <th>Ly do nhap vien</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="benhAn" items="${benhAnList}">
            <tr>
                <td><c:out value="${benhAn.id}"/></td>
                <td><c:out value="${benhAn.benhNhanId.id}"/></td>
                <td><c:out value="${benhAn.benhNhanId.name}"/></td>
                <td><c:out value="${benhAn.ngayNhapVien}"/></td>
                <td><c:out value="${benhAn.ngayRaVien}"/></td>
                <td><c:out value="${benhAn.lyDoNhapVien}"/></td>

                <td>
                    <a href="/benh_an?action=edit&id=${benhAn.id}">Edit</a>
                    <a href="/benh_an?action=delete&id=${benhAn.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>