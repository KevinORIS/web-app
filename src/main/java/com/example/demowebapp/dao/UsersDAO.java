package com.example.demowebapp.dao;

import com.example.demowebapp.dao.AbstractJpaDAO;
import com.example.demowebapp.model.User;

import java.sql.Timestamp;
import java.util.Objects;

public class UsersDAO extends AbstractJpaDAO<Integer, User> {
    public User findUserByEmail(String email){
        return findFirst(String.format("email = '%s'", email.toLowerCase()));
    }

    public boolean active(final String email){
        User user = findUserByEmail(email);
        user.setActive(true);
        user.setUpdatedTs(new Timestamp(System.currentTimeMillis()));
        return Objects.isNull(update(user));
    }
}
