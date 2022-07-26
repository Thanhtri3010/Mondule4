package com.example.borrowbooks.repository;

import com.example.borrowbooks.model.UserBorrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserBorrowRepository extends JpaRepository<UserBorrow, Integer> {
    UserBorrow findByCode(Long code);
}
