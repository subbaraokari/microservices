package com.ust.bookservice.web.mappers;

import com.ust.bookservice.domain.Book;
import com.ust.bookservice.services.inventory.BookInventoryService;
import com.ust.bookservice.web.model.BookDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BookMapperDecorator implements BookMapper {
  private BookInventoryService bookInventoryService;
  private BookMapper bookMapper;

  @Autowired
  public void setBookInventoryService(BookInventoryService bookInventoryService) {
    this.bookInventoryService = bookInventoryService;
  }

  @Autowired
  public void setBookMapper(BookMapper bookMapper) {

    this.bookMapper = bookMapper;
  }

  @Override
  public Book bookDtoToBook(BookDto bookDto) {

    return bookMapper.bookDtoToBook(bookDto);
  }

  @Override
  public BookDto bookToBookDto(Book book) {

    return bookMapper.bookToBookDto(book);
  }

  @Override
  public BookDto bookToBookDtoWithInventory(Book book) {
    System.out.println("hello");
    BookDto bookDto = bookMapper.bookToBookDto(book);
    bookDto.setQuantityOnHand(bookInventoryService.getOnHandInventory(book.getId()));
    return bookDto;
  }
}
