<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/25/2020
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>edit customer</title>
</head>
<body>
<center>
    <h2>
        <a href="/customers">List All Customer</a>
    </h2>
</center>
<div align="center">
    <form method="post">
<%--        <input type="hidden" name="action" value="edit">--%>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Customer
                </h2>
            </caption>
                    <input type="hidden" name="customerId" size="45"
                           value="<c:out value='${customer.customerId}'/>"/>

            <tr>
                <th>Type customer:</th>
                <td>
<%--                    <select name="typeId">--%>
<%--                        <c:forEach items="${customerType}" var="type">--%>
<%--                            &lt;%&ndash;                            <c:if test="${type.id == customer.customerTypeId}">&ndash;%&gt;--%>
<%--                            &lt;%&ndash;                                <option value="${type.id}" selected>${type.name}</option>&ndash;%&gt;--%>
<%--                            <option value="${type.id}" ${type.id == customer.customerTypeId ? "selected" : ""}>${type.name}</option>--%>
<%--                            &lt;%&ndash;                            </c:if>&ndash;%&gt;--%>
<%--                            &lt;%&ndash;                            <c:if test="${type.id != customer.customerTypeId}">&ndash;%&gt;--%>
<%--                            &lt;%&ndash;                                <option value="${type.id}">${type.name}</option>&ndash;%&gt;--%>
<%--                            &lt;%&ndash;                            </c:if>&ndash;%&gt;--%>

<%--                        </c:forEach>--%>
<%--                    </select>--%>

                    <select name="typeId">
                        <c:forEach items="${customerType}" var="cusType">
                            <c:choose>
                                <c:when test="${cusType.id.equals(customer.customerTypeId.id)}">
                                    <option value="<c:out value='${cusType.id}'/>" selected><c:out
                                            value="${cusType.name}"></c:out></option>
                                </c:when>
                                <c:otherwise>
                                    <option value="<c:out value='${cusType.id}'/>"><c:out value="${cusType.name}"></c:out></option>
                                </c:otherwise>
                            </c:choose>

                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>name:</th>
                <td>
                    <input type="text" name="customerName" size="45"
                           value="<c:out value='${customer.customerName}'/>"/>
                </td>
            </tr>
            <tr>
                <th>birthday:</th>
                <td>
                    <input type="date" name="birthday" size="45"
                           value="<c:out value='${customer.customerBirthday}' />"/>
                </td>
            </tr>
            <tr>
                <th>gender:</th>
                <td>
                    <%--                    <input type="text" name="gender" size="45"--%>
                    <%--                           value="<c:out value='${customer.customerGender}' />"/>--%>
                    <select name="gender">
                        <%--                        <option value="1" >nam</option>--%>
                        <%--                        <option value="0" >nu</option>--%>
                        <option value="nam" ${customer.customerGender == 'nam' ? 'selected':''}>nam</option>
                        <option value="nu" ${customer.customerGender == 'nu' ? 'selected':''}>nu</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>IdCard:</th>
                <td>
                    <input type="text" name="idCard" size="45"
                           value="<c:out value='${customer.customerIdCard}' />"/>
                </td>
            </tr>
            <tr>
                <th>phone:</th>
                <td>
                    <input type="text" name="phone" size="45"
                           value="<c:out value='${customer.customerPhone}' />"/>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${customer.customerEmail}' />"/>
                </td>
            </tr>
            <tr>
                <th>address:</th>
                <td>
                    <input type="text" name="address" size="45"
                           value="<c:out value='${customer.customerAddress}' />"/>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>