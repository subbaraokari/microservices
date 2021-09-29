package com.ust.bookinventoryservice.web.controllers;

import com.ust.bookinventoryservice.repositories.BookInventoryRepository;
import com.ust.bookinventoryservice.web.mappers.BookInventoryMapper;
import com.ust.bookinventoryservice.web.model.BookInventoryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController //@Controller+@ResponseBody
public class BookInventoryController {
  private final BookInventoryRepository bookInventoryRepository;
  private final BookInventoryMapper bookInventoryMapper;

  @GetMapping("api/v1/book/{bookId}/inventory")
  List<BookInventoryDto> listBeersById(@PathVariable UUID bookId) {
    log.debug("Finding Inventory for bookId:" + bookId);
    return bookInventoryRepository.findAllByBookId(bookId)
      .stream()
      .map(bookInventoryMapper::bookInventoryToBookInventoryDto)
      .collect(Collectors.toList());
  }
}
