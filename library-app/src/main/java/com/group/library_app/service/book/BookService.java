package com.group.library_app.service.book;

import com.group.library_app.domain.user.User;
import com.group.library_app.domain.book.Book;
import com.group.library_app.domain.book.BookRepository;
import com.group.library_app.domain.user.UserRepository;
import com.group.library_app.domain.user.loanhistory.UserLoanHistory;
import com.group.library_app.domain.user.loanhistory.UserLoanHistoryRepository;
import com.group.library_app.dto.book.request.BookCreateRequest;
import com.group.library_app.dto.book.request.BookLoanRequest;
import com.group.library_app.repository.user.UserJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {
    @Autowired
    private  BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserLoanHistoryRepository userLoanHistoryRepository;


    @Transactional
    public void save(BookCreateRequest request) {
        bookRepository.save(new Book(request.getName()));
    }

    @Transactional
    public void loanBook(BookLoanRequest request) {
    Book book  =  bookRepository.findByName(request.getBookName()).orElseThrow(IllegalArgumentException::new);

    if(userLoanHistoryRepository.existsByBookNameAndIsReturn(book.getName(), false)) {
        throw new IllegalArgumentException("이미 누가 빌려감");
    }

    User user = userRepository.findByName(request.getUserName()).orElseThrow(IllegalArgumentException::new);
    user.loanBook(book.getName());

    }
    @Transactional
    public void returnBook(BookLoanRequest request) {
        User user = userRepository.findByName(request.getUserName()).orElseThrow(IllegalArgumentException::new);
        user.returnBook(request.getBookName());

    }
}
