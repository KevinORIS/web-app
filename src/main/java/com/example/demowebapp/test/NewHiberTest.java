package com.example.demowebapp.test;

import com.example.demowebapp.dao.EmployeeDAO;
import com.example.demowebapp.db.JPAService;

public class NewHiberTest {
    public static void main(String[] args) {

        JPAService.initialize();


        EmployeeDAO employeeDao = new EmployeeDAO();
        employeeDao.findAll().forEach(employee -> {
            System.out.println(employee);
        });
    }
}
