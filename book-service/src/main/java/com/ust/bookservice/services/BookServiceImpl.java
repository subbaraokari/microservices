package com.ust.bookservice.services;

import com.ust.bookservice.domain.Book;
import com.ust.bookservice.exceptions.BookNotFoundException;
import com.ust.bookservice.repositories.BookRepository;
import com.ust.bookservice.web.mappers.BookMapper;
import com.ust.bookservice.web.model.BookDto;
import com.ust.bookservice.web.model.BookEnum;
import com.ust.bookservice.web.model.BookPagedList;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
  private final BookRepository bookRepository;
  private final BookMapper bookMapper;
  @Override
  public BookPagedList listBooks(String bookName, BookEnum bookType,
                                 PageRequest pageRequest, Boolean showInventoryOnHand) {

    BookPagedList bookPagedList;
    Page<Book> bookPage;

    if (!StringUtils.isEmpty(bookName) && !StringUtils.isEmpty(bookType)) {
      //search both
      bookPage = bookRepository.findAllByBookNameAndBookType(bookName, bookType, pageRequest);
    } else if (!StringUtils.isEmpty(bookName) && StringUtils.isEmpty(bookType)) {
      bookPage = bookRepository.findAllByBookName(bookName, pageRequest);
    } else if (StringUtils.isEmpty(bookName) && !StringUtils.isEmpty(bookType)) {
      bookPage = bookRepository.findAllByBookType(bookType, pageRequest);
    } else {
      bookPage = bookRepository.findAll(pageRequest);
    }

    if (showInventoryOnHand){
      bookPagedList = new BookPagedList(bookPage
        .getContent()
        .stream()
        .map(bookMapper::bookToBookDto)
        .collect(Collectors.toList()),
        PageRequest
          .of(bookPage.getPageable().getPageNumber(),
            bookPage.getPageable().getPageSize()),
        bookPage.getTotalElements());
    } else {
      bookPagedList = new BookPagedList(bookPage
        .getContent()
        .stream()
        .map(bookMapper::bookToBookDto)
        .collect(Collectors.toList()),
        PageRequest
          .of(bookPage.getPageable().getPageNumber(),
            bookPage.getPageable().getPageSize()),
        bookPage.getTotalElements());
    }

    return bookPagedList;
  }

  @Override
  public BookDto getById(UUID bookId, Boolean showInventoryOnHand) {
    if (showInventoryOnHand) {
      return bookMapper.bookToBookDtoWithInventory(
        bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new)
      );
    } else {
      return bookMapper.bookToBookDto(
        bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new)
      );
    }
  }

  @Override
  public BookDto saveNewBook(BookDto bookDto) {
    return bookMapper.bookToBookDto(bookRepository.save(bookMapper.bookDtoToBook(bookDto)));
  }

  @Override
  public BookDto updateBook(UUID bookId, BookDto bookDto) {
    Book book = bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);

    book.setBookName(bookDto.getBookName());
    book.setBookType(bookDto.getBookType().name());
    book.setPrice(bookDto.getPrice());
    book.setIsbn(bookDto.getIsbn());

    return bookMapper.bookToBookDto(bookRepository.save(book));
  }

  @Override
  public BookDto getByIsbn(String isbn) {
    return bookMapper.bookToBookDto(bookRepository.findByIsbn(isbn));
  }
}
