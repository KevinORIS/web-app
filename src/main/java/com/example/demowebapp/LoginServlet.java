package com.example.demowebapp;

import com.example.demowebapp.dao.UserDAO;
import com.example.demowebapp.dao.UserDAOImpl;
import com.example.demowebapp.dao.UsersDAO;
import com.example.demowebapp.db.JPAService;
import com.example.demowebapp.model.User;
import com.example.demowebapp.utils.EncryptDecryptUtils;
import com.example.demowebapp.utils.ServletUtils;
import com.mysql.cj.Session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private UsersDAO userDAO = new UsersDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Login page request " + new Date());

        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null){
            ServletUtils.forwardJsp("blog", request, response);
            return;
        } else {
            ServletUtils.forwardJsp("login", request, response);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String email = request.getParameter("email");
        final String psw = request.getParameter("psw");

        User user = null;
        if ((user = userDAO.findUserByEmail(email)) != null) {
            if (user.getPassword().equals(EncryptDecryptUtils.encrypt(psw))) {

                if(!user.isActive()){
                    // ??
                    request.setAttribute("msg", "Not Activated. Please check your email. Or...");
                    ServletUtils.forwardJsp("login", request, response);
                    return;
                }

                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(90);

                // Store user object within HTTP Session
                session.setAttribute("user", user);

                ServletUtils.forwardJsp("blog", request, response);
                return;
            } else {
                response.getWriter().println("Bad credentials");
                return;
            }
        }


    }
}
