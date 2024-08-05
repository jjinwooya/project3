package com.group.library_app.controller.book;

import com.group.library_app.dto.book.request.BookCreateRequest;
import com.group.library_app.dto.book.request.BookLoanRequest;
import com.group.library_app.service.book.BookService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping("/book")
    public void saveBook(@RequestBody BookCreateRequest request) {
        bookService.save(request);
    }

    @PostMapping("/book/loan")
    public void loanBook(@RequestBody BookLoanRequest request) {
        bookService.loanBook(request);
    }
    @PutMapping("/book/return")
    public void returnBook(@RequestBody BookLoanRequest request){
        bookService.returnBook(request);
    }


}
