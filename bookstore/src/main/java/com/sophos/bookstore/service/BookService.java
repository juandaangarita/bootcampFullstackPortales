package com.sophos.bookstore.service;

import com.sophos.bookstore.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    public Book createBook(Book book);
    public List<Book> getAllBooks();
    public Optional<Book> getBookById(int id);
    public boolean deleteBookById(int id);
}
