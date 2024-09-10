package com.example.demowebapp;

import com.example.demowebapp.dao.OfficeDAO;
import com.example.demowebapp.model.Office;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OfficeServlet", value = "/show-offices")
public class OfficeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeDAO officeDAO = new OfficeDAO();

        List<Office> offices = officeDAO.findAll();

        request.setAttribute("offices", offices);

        ServletUtils.forwardJsp("offices", request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
