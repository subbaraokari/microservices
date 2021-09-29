package com.ust.bookinventoryservice.bootstrap;

import com.ust.bookinventoryservice.domain.BookInventory;
import com.ust.bookinventoryservice.repositories.BookInventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Component
public class BookInventoryBootStrap implements CommandLineRunner {
  public static final String BOOK_1_ISBN = "0631234200036";
  public static final String BOOK_2_ISBN = "0631234300019";
  public static final String BOOK_3_ISBN = "0083783375213";
  public static final UUID BOOK_1_UUID = UUID.fromString("2155420b-ee2b-4e52-98cd-cd4e8c91bb78");
  public static final UUID BOOK_2_UUID = UUID.fromString("c3a39986-3867-4bb6-a39c-2fc3db0000f7");
  public static final UUID BOOK_3_UUID = UUID.fromString("1cc57aa9-5509-4fd5-acc7-fdf611510192");
  private final BookInventoryRepository bookInventoryRepository;

  @Override
  public void run(String... args) throws Exception {
    if (bookInventoryRepository.count() == 0) {
      loadInitialInv();
    }
  }

  private void loadInitialInv() {
    bookInventoryRepository.save(BookInventory.builder()
      .bookId(BOOK_1_UUID)
      .isbn(BOOK_1_ISBN)
      .quantityOnHand(50)
      .build());
    bookInventoryRepository.save(BookInventory.builder()
      .bookId(BOOK_2_UUID)
      .isbn(BOOK_2_ISBN)
      .quantityOnHand(50)
      .build());
    bookInventoryRepository.save(BookInventory.builder()
      .bookId(BOOK_3_UUID)
      .isbn(BOOK_3_ISBN)
      .quantityOnHand(50)
      .build());
    log.debug("Loaded Inventory. Record count: " + bookInventoryRepository.count());
  }

}
