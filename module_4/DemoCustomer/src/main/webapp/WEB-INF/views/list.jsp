<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 04/01/2021
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/list" method="GET">
        <table>
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>AGE</th>
                <th>EMAIL</th>
            </tr>
            <c:forEach var="customer" items="${customerList}">
                <tr>
                    <td><c:out value="${customer.id}"/> </td>
                    <td><c:out value="${customer.name}"/> </td>
                    <td><c:out value="${customer.age}"/> </td>
                    <td><c:out value="${customer.email}"/> </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</body>
</html>
