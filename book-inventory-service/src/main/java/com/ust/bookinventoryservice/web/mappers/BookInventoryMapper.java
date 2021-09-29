package com.ust.bookinventoryservice.web.mappers;

import com.ust.bookinventoryservice.domain.BookInventory;
import com.ust.bookinventoryservice.web.model.BookInventoryDto;
import org.mapstruct.Mapper;

import java.awt.print.Book;

@Mapper(uses = DateMapper.class)
public interface BookInventoryMapper {
  BookInventoryDto bookInventoryToBookInventoryDto(BookInventory bookInventory);
  BookInventory bookInventoryDtoToBookInventory(BookInventoryDto bookInventoryDto);
}
