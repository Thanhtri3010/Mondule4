package com.example.repository;

import com.example.modle.Email;

import java.util.List;

public interface IEmailRepository {
    List<Email> findAll();

    void save(Integer id, Email email);

    Email findByID(int id);

    List<String> showLanguages();

    List<Integer> showPageSize();
}
