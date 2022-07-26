package com.example.borrowbooks.service;

import com.example.borrowbooks.model.UserBorrow;

import java.util.List;

public interface IUserBorrowService {
    List<UserBorrow> findAll();
    void save(UserBorrow userBorrow);
    UserBorrow findById(int id);

    UserBorrow findByCode(Long code);

    void remove(UserBorrow userBorrow);
}
