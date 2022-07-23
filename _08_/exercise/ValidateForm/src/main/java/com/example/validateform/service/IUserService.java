package com.example.validateform.service;


import com.example.validateform.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void save(User user);
}
