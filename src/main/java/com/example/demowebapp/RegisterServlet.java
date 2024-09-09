package com.example.demowebapp;


import com.example.demowebapp.dao.RolesDAO;
import com.example.demowebapp.dao.UserDAOImpl;
import com.example.demowebapp.dao.UsersDAO;
import com.example.demowebapp.model.User;
import com.example.demowebapp.utils.EncryptDecryptUtils;
import com.example.demowebapp.utils.MailUtils;
import com.example.demowebapp.utils.ServletUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet", value = "/reg-user")
public class RegisterServlet extends HttpServlet {




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletUtils.forwardJsp("reg", request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String password = request.getParameter("psw");
        String repeatedPassword = request.getParameter("psw2");

        if (password.equals(repeatedPassword)) {
            User user = new User();
            user.setEmail(email);
            user.setName(name);

            String encryptedPassword = EncryptDecryptUtils.encrypt(password);
            user.setPassword(encryptedPassword);

            UsersDAO userDAO = new UsersDAO();
            RolesDAO rolesDAO = new RolesDAO();
            try {

                user.setRole(rolesDAO.findById(3));
                userDAO.create(user);
                boolean isCreated = userDAO.findUserByEmail(email) != null;
                if (isCreated){
                    // just created - not active!
                    // send msg with instructions

                    String subject = "Welcome to Crazy Users App";
                    String token = EncryptDecryptUtils.encrypt(user.getEmail());
                        String msg = String.format(
                            "<b> To confirm your account , please <a href='http://localhost:8080/web_app/activate?token=%s'>click</a></b>", token);

                    MailUtils.sendHtmlMail(user.getEmail(), subject, msg, null, null);
                    request.setAttribute("msg", "Check Your Email to confirm Registration");
                    ServletUtils.forwardJsp("reg", request, response);
                    return;
                    //ServletUtils.forwardJsp("blog", request, response);
                }

                else
                    request.setAttribute("msg", "Error User Registration");
            } catch (Exception e){
                e.printStackTrace();
                request.setAttribute("msg", "Internal Error User Registration");
                String message = ExceptionUtils.getMessage(e.getCause());
                String stackTrace = ExceptionUtils.getStackTrace(e);
                request.setAttribute("cause", StringUtils.isEmpty(message) ? ExceptionUtils.getMessage(e) : message);
                request.setAttribute("stack-trace", stackTrace);
                ServletUtils.forwardJsp("reg", request, response);
                return;
            }


            return;
        } else {
            response.getWriter().println("Password mismatch");
            return;
        }
    }
}