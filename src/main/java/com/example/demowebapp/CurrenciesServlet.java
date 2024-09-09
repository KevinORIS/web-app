package com.example.demowebapp;

import com.example.demowebapp.services.XMLCurrencyParser;
import com.example.demowebapp.utils.HTMLTableBuilder;
import org.apache.commons.lang3.StringUtils;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import static com.example.demowebapp.utils.ServletUtils.*;

@WebServlet(name = "CurrenciesServlet", value = "/rate-request")
public class CurrenciesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String path = "currencies_request_form";

        if(StringUtils.isEmpty(request.getParameter("amount"))){
            // 0. Show currencies request form
            forward(path, request, response);
            return;
        }

        // 1. Amount & currency are presented -> client request to calculate
        // 1.1 get param values
        long amount = getLongParameter(request, "amount");
        String code = request.getParameter("code");

        // 1.2 Get Currency Rate
        double rate = Double.parseDouble(XMLCurrencyParser.getCurrency(code));

        if(code.equals("643")){
            rate /= 100;
        }

        // 1.3 Calculate final Amount
        double result = amount * rate;

        // 1.4 Make response
        include(path, "Result Amount:" + result , request, response );
        return;

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
