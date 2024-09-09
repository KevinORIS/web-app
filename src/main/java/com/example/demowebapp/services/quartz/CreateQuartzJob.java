package com.example.demowebapp.services.quartz;

import com.example.demowebapp.dao.UserDAO;
import com.example.demowebapp.dao.UserDAOImpl;
import com.example.demowebapp.services.CurrencySenderService;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

//create CreateQuartzJob class that implements Job
public class CreateQuartzJob implements Job{

    //Create instance of logger

    private static UserDAO userDAO = new UserDAOImpl();
    private Logger log = Logger.getLogger(CreateQuartzJob.class);

    //execute Job by using execute() method of the Job interface
    public void execute(JobExecutionContext jExeCtx) throws JobExecutionException {//handle JobExecutionException

        //debug message
        log.debug("CreateQuartzJob is running......");
        CurrencySenderService.sendCurrencies(userDAO.findAll());

        log.debug("CreateQuartzJob is finishing.......");
    }
}