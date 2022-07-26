package com.example.borrowbooks.service;

import com.example.borrowbooks.model.Book;

import java.util.List;

public interface IBookService {

    List<Book> findAllBook();

    Book save(Book book);

    Book findById(int id);
}
