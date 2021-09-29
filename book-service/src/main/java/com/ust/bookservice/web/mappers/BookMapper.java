package com.ust.bookservice.web.mappers;

import com.ust.bookservice.domain.Book;
import com.ust.bookservice.web.model.BookDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
@DecoratedWith(BookMapperDecorator.class)
public interface BookMapper {
  Book bookDtoToBook(BookDto bookDto);
  BookDto bookToBookDto(Book book);
  BookDto bookToBookDtoWithInventory(Book book);
}
