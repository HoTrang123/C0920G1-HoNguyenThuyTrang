<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/21/2020
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="users">List All Users</a>
    </h2>
</center>

<form method="post">

            <h2>Edit User</h2>

<%--        <c:if test="${user != null}">--%>
<%--            <input type="hidden" name="id" value="<c:out value='${user.id}' />"/>--%>
<%--        </c:if>--%>
        <tr>
            <th>User Name:</th>
            <td>
                <input type="text" name="name" size="45"
                       value="<c:out value='${user.getName()}' />"
                />
            </td>
        </tr>
        <tr>
            <th>User Email:</th>
            <td>
                <input type="text" name="email" size="45"
                       value="<c:out value='${user.getEmail()}' />"
                />
            </td>
        </tr>
        <tr>
            <th>Country:</th>
            <td>
                <input type="text" name="country" size="15"
                       value="<c:out value='${user.getCountry()}' />"
                />
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Save"/>
            </td>
        </tr>
</form>
</body>
</html>
