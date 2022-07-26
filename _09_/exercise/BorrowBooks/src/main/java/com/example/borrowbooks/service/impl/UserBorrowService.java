package com.example.borrowbooks.service.impl;

import com.example.borrowbooks.model.UserBorrow;
import com.example.borrowbooks.repository.IUserBorrowRepository;
import com.example.borrowbooks.service.IUserBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserBorrowService implements IUserBorrowService {
    @Autowired
    private IUserBorrowRepository userBorrowRepository;

    @Override
    public List<UserBorrow> findAll() {
        return userBorrowRepository.findAll();
    }

    @Override
    public void save(UserBorrow userBorrow) {
        long code = (long)Math.floor(Math.random() *99999)+1000;
        userBorrow.setCode(code);
        userBorrowRepository.save(userBorrow);
    }

    @Override
    public UserBorrow findById(int id) {
        return userBorrowRepository.findById(id).orElse(null);
    }

    @Override
    public UserBorrow findByCode(Long code) {
        return userBorrowRepository.findByCode(code);
    }

    @Override
    public void remove(UserBorrow userBorrow) {
        userBorrowRepository.delete(userBorrow);
    }
}
