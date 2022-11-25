package com.sophos.bookstore.service;

import com.sophos.bookstore.entity.Book;
import com.sophos.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImplementation implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public boolean deleteBookById(int id) {
        return getBookById(id).map(book -> {
            bookRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
