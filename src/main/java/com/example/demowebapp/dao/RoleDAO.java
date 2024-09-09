package com.example.demowebapp.dao;

import com.example.demowebapp.model.Role;
import com.example.demowebapp.model.User;

import java.sql.SQLException;

public interface RoleDAO {
    Role findRoleById(int id) throws SQLException;
    Role findByUser(User user);
}
