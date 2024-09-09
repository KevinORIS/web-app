package com.example.demowebapp;

import com.example.demowebapp.model.User;
import com.example.demowebapp.utils.ServletUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "CarsServlet", value = "/show-cars")
public class CarsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        User user = ServletUtils.getUserInSession(request);

        if (user == null) {
            request.setAttribute("msg", "You should login first");
        } else if (!user.getRole().getName().equalsIgnoreCase("Admin")) {
            request.setAttribute("msg", "You should have Admin role");
            ServletUtils.forwardJsp("basic-msg", request, response);
            return;
        } else {
            request.setAttribute("cars", Arrays.asList("BMW", "HONDA", "OPEL"));
            ServletUtils.forwardJsp("cars-table", request, response);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
