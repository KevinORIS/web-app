<%@ page import="java.util.List" %>
<%@ page import="com.example.demowebapp.XMLCurrencyParser" %><%--
  Created by IntelliJ IDEA.
  User: st
  Date: 11.07.2024
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Table</title>
</head>
<body>
<!-- declaration -->
<%!
    int counter = 0;
%>
<%-- Scriptlet --%>
<%
    // Java is here
    counter++;
    List<String> currencies = (List<String>)request.getAttribute("currencies");
    System.out.println("Hello from JSP Scriptlet");
    int x = (int) (Math.random() * 10) + 1;
    response.getWriter().println(x);
%>
<%-- HTML is here   --%>
<h1>PAGE COUNTER: <%=counter%></h1>
<table border="1">
    <tr>
        <th>CURRENCY</th>
        <th>RATE</th>
    </tr>

    <tr>
        <td> <!-- JSP Expression -->
            <%=XMLCurrencyParser.getCurrency("840")%>
        </td>

        <td> 840 </td>
        <td> <!-- JSP Expression -->
            <%=XMLCurrencyParser.getCurrency("978")%>
        </td>

        <td>978</td>
    </tr>
    <%
        }
    %>

</table>
</body>
</html>
