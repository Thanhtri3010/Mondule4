package com.example.service.impl;

import com.example.modle.Email;
import com.example.repository.IEmailRepository;
import com.example.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements IEmailService {

    @Autowired
    private IEmailRepository emailRepository;

    @Override
    public List<Email> findAll() {
        return emailRepository.findAll();
    }

    @Override
    public void save(Integer id, Email email) {
        emailRepository.save(id, email);
    }

    @Override
    public Email findByID(int id) {
        return emailRepository.findByID(id);
    }

    @Override
    public List<String> showLanguages() {
        return emailRepository.showLanguages();
    }

    @Override
    public List<Integer> showPageSize() {
        return emailRepository.showPageSize();
    }
}
