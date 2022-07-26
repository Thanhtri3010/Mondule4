package com.example.borrowbooks.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String bookName;
    private String author;
    private Integer quantity;

    @OneToMany(mappedBy = "book")
    private Set<UserBorrow> userBorrow;

    public Book() {
    }

    public Book(int bookId, String bookName, String author, Integer quantity, Set<UserBorrow> userBorrow) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.quantity = quantity;
        this.userBorrow = userBorrow;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Set<UserBorrow> getUserBorrow() {
        return userBorrow;
    }

    public void setUserBorrow(Set<UserBorrow> userBorrow) {
        this.userBorrow = userBorrow;
    }
}
