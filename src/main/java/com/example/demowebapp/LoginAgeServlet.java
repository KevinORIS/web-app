package com.example.demowebapp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "LoginAgeServlet", value = "/login-age")
public class LoginAgeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Login page request " + new Date());
        request.getRequestDispatcher("age_login.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userFirstName = request.getParameter("first");
        String userLastName = request.getParameter("last");

        String userPwd = request.getParameter("password");
        String userAge = request.getParameter("age");


        // Check in DB

        if (userFirstName.equalsIgnoreCase("John")) {
            if (userPwd.equals("1234")) {
                String gender = request.getParameter("gender");
                if (gender.equalsIgnoreCase("male")) {
                    response.getWriter().println("Welcome back, mr " + userFirstName + " " + userLastName);
                } else {
                    response.getWriter().println("Welcome back, ms " + userFirstName + " " + userLastName);
                }

            } else {
                // include
                response.getWriter().println("</h2>Incorrect UserName or Password</h2>");
                RequestDispatcher rd = request.getRequestDispatcher("/login-age");
                rd.include(request, response);
            }

            if (Integer.parseInt(userAge) >= 18) {
                request.getRequestDispatcher("img/beer.jpg").forward(request, response);
            } else {
                request.getRequestDispatcher("img/cola.jpg").forward(request, response);
            }

        }

    }
}
