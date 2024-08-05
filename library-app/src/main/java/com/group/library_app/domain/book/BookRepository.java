package com.group.library_app.domain.book;

import org.springframework.data.jpa.repository.JpaRepository;
import com.group.library_app.domain.book.Book;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByName(String name);


}
