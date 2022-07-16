package com.example.service;

import com.example.modle.Email;

import java.util.List;

public interface IEmailService {
    List<Email> findAll();

    void save(Integer id, Email email);

    Email findByID(int id);

    List<String> showLanguages();

    List<Integer> showPageSize();

}
