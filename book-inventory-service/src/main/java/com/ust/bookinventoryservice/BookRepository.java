package com.ust.bookinventoryservice;

import com.ust.bookinventoryservice.domain.BookInventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<BookInventory, UUID> {
  List<BookInventory> findAllByBookId(UUID bookId);
}
