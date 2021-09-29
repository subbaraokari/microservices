package com.ust.bookservice.web.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BookPagedList extends PageImpl<BookDto> {

  public BookPagedList(List<BookDto> content, Pageable pageable, long total) {
    super(content, pageable, total);
  }

  public BookPagedList(List<BookDto> content) {
    super(content);
  }
}
