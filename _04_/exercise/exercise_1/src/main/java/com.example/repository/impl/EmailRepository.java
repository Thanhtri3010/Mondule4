package com.example.repository.impl;

import com.example.modle.Email;
import com.example.repository.IEmailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository implements IEmailRepository {

    private static List<Email> emailList = new ArrayList<>();
    private static List<String> languageList = new ArrayList<>();
    private static List<Integer> pageSizeList = new ArrayList<>();

    static {
        emailList.add(new Email(1, "English", 5, true, "Tri"));
        emailList.add(new Email(2, "Chinese", 10, true, "Lam"));
        emailList.add(new Email(3, "Japanese", 15, false, "Bao"));
        emailList.add(new Email(4, "Vietnamese", 25, false, "Hieu"));
    }

    static {
        languageList.add("English");
        languageList.add("Chinese");
        languageList.add("Japanese");
        languageList.add("VietNamese");
    }

    static {
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(20);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
    }

    @Override
    public List<Email> findAll() {
        return emailList;
    }

    @Override
    public void save(Integer id, Email email) {
        for (Email item : emailList) {
            if (id.equals(item.getId())) {
                item.setLanguages(email.getLanguages());
                item.setPageSize(email.getPageSize());
                item.setSpamsFilter(email.isSpamsFilter());
                item.setSignature(email.getSignature());
            }
        }
    }

    @Override
    public Email findByID(int id) {
        Email email = null;
        for (Email item : emailList) {
            if (item.getId() == id) {
                email = new Email(item.getId(), item.getLanguages(), item.getPageSize(), item.isSpamsFilter(), item.getSignature());
            }
        }
        return email;
    }

    @Override
    public List<String> showLanguages() {
        return languageList;
    }

    @Override
    public List<Integer> showPageSize() {
        return pageSizeList;
    }
}
