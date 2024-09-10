<%@ page import="com.example.demowebapp.model.Office" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10.09.2024
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Offices</title>
</head>
<body>
<h1>Offices</h1>
<table border="1">
    <thead>
    <tr>
        <th>officeCode</th>
        <th>city</th>
        <th>phone</th>
        <th>addressLine1</th>
        <th>addressLine2</th>
        <th>state</th>
        <th>country</th>
        <th>postalCode</th>
        <th>territory</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Office> offices = (List<Office>) request.getAttribute("offices");
        for(Office office : offices) {
    %>
    <tr>
        <th><%=office.getOfficeCode()%></th>
        <th><%=office.getCity()%></th>
        <th><%=office.getPhone()%></th>
        <th><%=office.getAddressLine1()%></th>
        <th><%=office.getAddressLine2()%></th>
        <th><%=office.getState()%></th>
        <th><%=office.getCountry()%></th>
        <th><%=office.getPostalCode()%></th>
        <th><%=office.getTerritory()%></th>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
