package com.ust.bookservice.services.inventory;

import com.ust.bookservice.services.inventory.model.BookInventoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
@RequiredArgsConstructor
@Component
public class InventoryServiviceFeignClientFailover implements InventoryServiceFeignClient {
  private final InventoryServiceFailOverClient inventoryServiceFailOverClient;

  @Override
  public ResponseEntity<List<BookInventoryDto>> getOnhandInventory(UUID bookId) {
    return inventoryServiceFailOverClient.getOnhandInventory();
  }
}
