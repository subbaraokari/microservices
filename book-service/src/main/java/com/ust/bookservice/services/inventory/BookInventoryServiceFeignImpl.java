package com.ust.bookservice.services.inventory;

import com.ust.bookservice.services.inventory.model.BookInventoryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
@Profile("local-discovery")
public class BookInventoryServiceFeignImpl implements BookInventoryService {
  private final InventoryServiceFeignClient inventoryServiceFeignClient;

  @Override
  public Integer getOnHandInventory(UUID bookId) {
    log.debug("Calling Inventory Service - BookId: " + bookId);

    ResponseEntity<List<BookInventoryDto>> responseEntity = inventoryServiceFeignClient.
      getOnhandInventory(bookId);
    Integer onHand = Objects.requireNonNull(responseEntity.getBody())
      .stream()
      .mapToInt(BookInventoryDto::getQuantityOnHand)
      .sum();
    log.debug("BookId: " + bookId + " On hand is: " + onHand);
    return onHand;
  }
}
