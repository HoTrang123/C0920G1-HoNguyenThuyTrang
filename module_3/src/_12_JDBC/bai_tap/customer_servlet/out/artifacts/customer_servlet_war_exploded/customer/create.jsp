<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/28/2020
  Time: 8:40 PM
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
    <h2>
        <a href="customers">List All Customer</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Customer</h2>
            </caption>
            <tr>
                <th>Customer Type:</th>
                <td>
                    <select name="typeId">
                        <c:forEach items="${customerTypeList}" var="customerType">
                            <option value="<c:out value='${customerType.customer_type_id}' />" selected><c:out value="${customerType.customerTypeName}"></c:out></option>

                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Customer Name:</th>
                <td>
                    <input value="${name}" type="text" name="name" id="name" size="45" required/>
                </td>
            </tr>
            <tr>
                <th>Birthday:</th>
                <td>
                    <input value="${birthday}" type="date" name="birthday" id="birthday" size="45" required/>
                    <p style="color: red">${messageBirthDay} </p>

                </td>
            </tr>
            <tr>
                <th>Gender:</th>
                <td>
                    <select name="gender">
                        <option value="nam">nam</option>
                        <option value="nu">nu</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>IdCard:</th>
                <td>
                    <input value="${idCard}" type="text" name="idCard" id="idCard" size="45" required />
                </td>
            </tr>
            <tr>
                <th>Phone:</th>
                <td>
                    <input value="${phone}" type="text" name="phone" id="phone" size="45" required/>
                    <p style="color: red ">${messagePhone}</p>

                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input value="${email}" type="text" name="email" id="email" size="45" required/>
                    <p style="color: red">${messageEmail}</p>

                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input value="${address}" type="text" name="address" id="address" size="45" required/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" name="action" value="create"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>