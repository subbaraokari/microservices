package com.ust.bookservice.services.inventory;

import com.ust.bookservice.domain.Book;
import com.ust.bookservice.services.inventory.model.BookInventoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "inventory-service",fallback = InventoryServiceFailOverClient.class)
public interface InventoryServiceFeignClient {
  @RequestMapping(method = RequestMethod.GET, value = BookInventoryServiceRestTemplateImpl.INVENTORY_PATH)
  ResponseEntity<List<BookInventoryDto>> getOnhandInventory(@PathVariable UUID bookId);
}
