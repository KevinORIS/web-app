<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.demowebapp.services.XMLCurrencyParser" %><%--
  Created by IntelliJ IDEA.
  User: sharlan_a
  Date: 11.07.2024
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Offices</title>
</head>
<body>
<!-- Declaration -->
<c:set var="counter" scope="session" value="${0}"/>
<!-- Scriptlet  -->

<c:if test="${offices == null}">
    <h3>No offices Found</h3>
</c:if>

<c:if test="${offices != null}">
    <!-- Build table -->
    <table border="1">
        <tr>
            <th>OFFICE CODE</th>
            <th>CITY</th>
            <th>PHONE</th>
            <th>ADDRESS LINE #1</th>
            <th>ADDRESS LINE #2</th>
            <th>STATE</th>
            <th>COUNTRY</th>
            <th>POSTAL CODE</th>
            <th>TERRITORY</th>
            <th>ACTION</th> <!--UPDATE, DELETE-->
        </tr>
        <c:forEach var="office" items="${offices}">
            <tr>
                <td>
                    <c:out value="${offices.officeCode}"/>
                </td>
                <td>
                    <c:out value="${offices.city}"/>
                </td>
                <td>
                    <c:out value="${offices.phone}"/>
                </td>
                <td>
                    <c:out value="${offices.addressLine1}"/>
                </td>
                <td>
                    <c:out value="${offices.addressLine2}"/>
                </td>
                <td>
                    <c:out value="${offices.state}"/>
                </td>
                <td>
                    <c:out value="${offices.country}"/>
                </td>
                <td>
                    <c:out value="${offices.postalCode}"/>
                </td>
                <td>
                    <c:out value="${offices.territory}"/>
                </td>

            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
