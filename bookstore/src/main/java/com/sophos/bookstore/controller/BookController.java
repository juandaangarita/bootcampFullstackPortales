package com.sophos.bookstore.controller;

import com.sophos.bookstore.entity.Book;
import com.sophos.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getBooks(){
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id){
        return bookService.getBookById(id)
                .map(book -> new ResponseEntity<>(book, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        return new ResponseEntity<>(bookService.createBook(book), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBookById(@PathVariable("id") int id){
        if (bookService.deleteBookById(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
