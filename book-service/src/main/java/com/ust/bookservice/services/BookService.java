package com.ust.bookservice.services;

import com.ust.bookservice.domain.Book;
import com.ust.bookservice.web.model.BookDto;
import com.ust.bookservice.web.model.BookEnum;
import com.ust.bookservice.web.model.BookPagedList;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BookService {
  BookPagedList listBooks(String bookName, BookEnum bookType,
                          PageRequest pageRequest, Boolean showInventoryOnHand);

  BookDto getById(UUID bookId, Boolean showInventoryOnHand);

  BookDto saveNewBook(BookDto bookDto);

  BookDto updateBook(UUID bookId, BookDto bookDto);

  BookDto getByIsbn(String upc);
}
