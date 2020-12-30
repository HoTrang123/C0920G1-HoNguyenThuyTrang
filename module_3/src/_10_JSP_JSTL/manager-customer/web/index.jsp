<%@ page import="java.util.List" %>
<%@ page import="customer.Customer" %>
<%@ page import="customer.CustomerDAO" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/15/2020
  Time: 4:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>$Title$</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
<%
  List<Customer> customerList = CustomerDAO.getCustomerList();
  request.setAttribute("customerList", customerList);
%>
<h1 class="text-center">Danh sách khách hàng</h1>
<table class="table table-striped">
  <tr>
    <th>Tên</th>
    <th>Ngày sinh</th>
    <th>Địa chỉ</th>
    <th>Ảnh</th>
    <th>Thay đổi</th>
  </tr>
  <tbody>
  <c:forEach var="customer" items="${customerList}">
    <tr>
      <td><c:out value="${customer.name}"/></td>
      <td><c:out value="${customer.dateOfBirth}"/></td>
      <td><c:out value="${customer.address}"/></td>
      <td><img src="${customer.image}"></td>
      <td>
        <button class="btn btn-warning">Edit</button>
        <button class="btn btn-outline-danger">Delete</button>
      </td>
    </tr>
  </c:forEach>
  <img src="././customer/anh_1.jpeg">
  </tbody>
</table>
</body>
</html>