package com.example.demowebapp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class ServletUtils {
    public static void forward(final String path, final HttpServletRequest request,
                               final HttpServletResponse response) throws ServletException, IOException {
        System.out.println(new Date() + ". Forward to : " + path);
        request.getRequestDispatcher(path).forward(request,response);
    }

    public static void forwardJsp(final String path, final HttpServletRequest request,
                               final HttpServletResponse response) throws ServletException, IOException {
        System.out.println(new Date() + ". Forward to : " + path);
        request.getRequestDispatcher(path + ".jsp").forward(request,response);
    }

    public static void include(final String path, final String msg, final double result, final HttpServletRequest request,
                               final HttpServletResponse response) throws ServletException, IOException {
        System.out.println(new Date() + ". Include for : " + path);
        response.getWriter().println("<h3>" + msg + "</h3>");

        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.include(request,response);
    }

    public static void redirect(final String path, final HttpServletResponse response) throws IOException {
        System.out.println(new Date() + ". Redirect for : " + path);
        response.sendRedirect(path);
    }

    public static long getLongParameter(final HttpServletRequest request, final String paramName){
        return Long.parseLong(request.getParameter(paramName));
    }
}
