package com.example.demowebapp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Random;

@WebServlet(name = "GuessNumberServlet", value = "/guess-number")
public class GuessNumberServlet extends HttpServlet {

    private Integer x;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();

        // /guess-number?min=1&max=10
        if(Objects.isNull(x)){
            //Generate Random value
            Random random = new Random();

            int from = Integer.valueOf(request.getParameter("min"));
            int to = Integer.valueOf(request.getParameter("max"));
           // x = random.nextInt(from, to + 1);
        } else {
            // /guess-number?answer=5
            int answer = Integer.valueOf(request.getParameter("answer"));
            if(x == answer){
                printWriter.println("<h1> YOU WON =] !</h1>");
            } else {
                printWriter.println("<h1> YOU LOSE =[ !</h1>");
            }
        }

        printWriter.println("<a href='guess-number?min=1&max=10'> Play Again from 1 to 10 </h1>");

    }


}
