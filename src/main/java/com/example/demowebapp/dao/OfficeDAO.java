package com.example.demowebapp.dao;

import com.example.demowebapp.model.Office;

import java.util.Set;

public interface OfficeDAO {
    Set<Office> findAll();
}
