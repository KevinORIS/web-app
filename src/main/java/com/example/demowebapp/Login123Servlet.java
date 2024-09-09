package com.example.demowebapp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "Login123Servlet", value = "/login1234")
public class Login123Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Login page request " + new Date());
        request.getRequestDispatcher("/html/login.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String userName = request.getParameter("first");
        String userPwd = request.getParameter("password");

        // Check in DB
        if(userName.equalsIgnoreCase("John")){
            if(userPwd.equals("1234")){
                String gender = request.getParameter("gender");
                int age = Integer.valueOf(request.getParameter("age"));
                if(age >= 18 && age <= 27){
                    response.getWriter().println("Army =[");
                }
                if(gender.equalsIgnoreCase("male")){
                    response.getWriter().println("Welcome back, mr " + userName);
                } else {
                    response.getWriter().println("Welcome back, ms " + userName);
                }

                 return;
            } else {
                // include
                response.getWriter().println("<h2>Incorrect UserName or Password</h2>");

                RequestDispatcher rd =  request.getRequestDispatcher("/html/login.html");
                rd.include(request, response);

                return;

            }
        }
    }
}
