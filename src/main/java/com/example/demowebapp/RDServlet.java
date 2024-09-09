package com.example.demowebapp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@WebServlet(name = "RDServlet", value = "/rd-test")
public class RDServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Request SessionId: " + request.getRequestedSessionId());

        String val = Optional.ofNullable(request.getParameter("param")).orElse("empty");

        if(val.equals("page_1")){
            RequestDispatcher rd = request.getRequestDispatcher("/html/page_1.html");
            rd.forward(request, response);
        } else {
            response.sendRedirect("https://www.nbrb.by/Services/XmlExRates.aspx");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
