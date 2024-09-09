package com.example.demowebapp;

import com.example.demowebapp.dao.UserDAO;
import com.example.demowebapp.dao.UserDAOImpl;
import com.example.demowebapp.services.CurrencySenderService;
import com.example.demowebapp.services.quartz.QuartzScheduler;
import org.apache.log4j.Logger;
import org.quartz.SchedulerException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CurrenciesSenderServlet", value = "/send-currencies")
public class CurrenciesSenderServlet extends HttpServlet {
    UserDAO userDAO = new UserDAOImpl();
    
    private Logger log = org.apache.log4j.Logger.getLogger((CurrenciesSenderServlet .class));

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if(session.getAttribute("user") == null){
            request.setAttribute("msg", "You should login to perform such operation");
            ServletUtils.forwardJsp("login", request, response);

        }

        String job = request.getParameter("job");
        String action = request.getParameter("action");
        String interval = request.getParameter("interval");

        if(job.equals("1")){
            if(action.equals("start")){
                log.info("job #1 has been started via Servlet");
                try {
                    if (interval != null) {
                        int i = Integer.parseInt(interval);
                        if (i > 0 && i < 86400) {
                            QuartzScheduler.TIME_INTERVAL = i;
                        } else {
                            log.warn("Invalid TIME_INTERVAL " + i);
                        }
                    }
                    QuartzScheduler.jobOne();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else if(action.equals("stop")){
                try {
                    log.info("Trying to stop job #1");
                    QuartzScheduler.stopJob();
                } catch (SchedulerException e) {
                    throw new RuntimeException(e);
                }
            }

        } else {
            log.info("Common sender Servlet");
            CurrencySenderService.sendCurrencies(userDAO.findAll());
            request.setAttribute("msg", "Currencies has been send");
            ServletUtils.forwardJsp("blog", request, response);
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
