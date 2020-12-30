<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/28/2020
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Management Application</title>
</head>
<body>
<center>
    <h1>Customer Management</h1>
    <div>
        <form class="form-inline my-2 my-lg-0">
            <input type="hidden" name="action" value="search">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="customerName">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>

        </form>
    </div>
    <h2>
        <a href="/customers?action=create">Add New Customer</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Customer</h2></caption>
        <tr>
            <th>ID</th>
            <th>TypeId</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Gender</th>
            <th>Id Card</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="listCus" items="${customerList}">
            <tr>
                <td><c:out value="${listCus.customerId}"/></td>
                <td><c:out value="${listCus.customerTypeId.customerTypeName}"/></td>
                <td><c:out value="${listCus.customerName}"/></td>
                <td><c:out value="${listCus.customerBirthday}"/></td>
                <td><c:out value="${listCus.customerGender}"/></td>
                <td><c:out value="${listCus.customerIdCard}"/></td>
                <td><c:out value="${listCus.customerPhone}"/></td>
                <td><c:out value="${listCus.customerEmail}"/></td>
                <td><c:out value="${listCus.customerAddress}"/></td>
                <td>
                    <a href="/customers?action=edit&id=${listCus.customerId}">Edit</a>
                    <a href="/customers?action=delete&id=${listCus.customerId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>