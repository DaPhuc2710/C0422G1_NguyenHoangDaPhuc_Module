package com.example.register_form.service;

import com.example.register_form.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    void save(User user);
}
