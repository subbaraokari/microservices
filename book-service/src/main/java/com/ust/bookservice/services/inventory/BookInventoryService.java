package com.ust.bookservice.services.inventory;

import java.util.UUID;

public interface BookInventoryService {
  Integer getOnHandInventory(UUID bookId);
}
