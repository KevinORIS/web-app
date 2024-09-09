package com.example.demowebapp;

import com.example.demowebapp.dao.UserDAOImpl;
import com.example.demowebapp.dao.UsersDAO;
import com.example.demowebapp.model.User;
import com.example.demowebapp.utils.EncryptDecryptUtils;
import com.example.demowebapp.utils.ServletUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ActivateServlet", value = "/activate")
public class ActivateServlet extends HttpServlet {

    private UsersDAO userDAO = new UsersDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = request.getParameter("token");
        if(token != null){

            // escape chars
            // '+' -> ' '
            token = token.replaceAll(" ", "+");

            String email = EncryptDecryptUtils.decrypt(token);

            User user = userDAO.findUserByEmail(email);
            if(user != null){
                // User found & should be activated
                boolean isActivated = userDAO.active(email);
                if(isActivated){
                    request.setAttribute("msg", "WELCOME. YOU ARE ACTIVATED");
                    ServletUtils.forwardJsp("blog", request, response);
                    return;
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
