package com.ust.bookservice.repositories;

import com.ust.bookservice.domain.Book;
import com.ust.bookservice.web.model.BookEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
  Page<Book> findAllByBookName(String bookName, Pageable pageable);

  Page<Book> findAllByBookType(BookEnum bookType, Pageable pageable);

  Page<Book> findAllByBookNameAndBookType(String bookName, BookEnum bookType,
                                          Pageable pageable);
  Book findByIsbn(String isbn);
}
