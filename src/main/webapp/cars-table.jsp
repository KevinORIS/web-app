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
    <title>Cars Table</title>
</head>
<body>
<!-- Declaration -->
<c:set var="counter" scope="session" value="${0}"/>
<!-- Scriptlet  -->
<h4>Counter:
    <c:out value="${counter = counter + 1}"/>
</h4>
<c:if test="${cars == null}">
    <h3>No cars to view</h3>
</c:if>

<c:if test="${cars != null}">
    <!-- Build table -->
    <table border="1">
        <tr>
            <th>NAME</th>
            <th>PRICE</th>
        </tr>
        <c:forEach var="car" items="${cars}">
            <tr>
                <td>
                    <c:out value="${car}"/>
                </td>
                <td>
                    <c:out value="${ 2000 + 2000}"/>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
