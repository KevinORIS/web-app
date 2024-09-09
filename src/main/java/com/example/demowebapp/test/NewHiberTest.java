package com.example.demowebapp.test;

import com.example.demowebapp.dao.EmployeeDao;
import com.example.demowebapp.db.JPAService;
import com.example.demowebapp.db.config.JpaConfiguration;
import com.example.demowebapp.entity.Employee;

public class NewHiberTest {
    public static void main(String[] args) {

        JPAService.initialize();


        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.findAll().forEach(employee -> {
            System.out.println(employee);
        });
    }
}
