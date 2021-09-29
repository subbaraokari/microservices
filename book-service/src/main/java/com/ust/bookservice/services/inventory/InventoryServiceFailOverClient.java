package com.ust.bookservice.services.inventory;

import com.ust.bookservice.services.inventory.model.BookInventoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@FeignClient(name = "inventory-failover")
public interface InventoryServiceFailOverClient {
  @RequestMapping(method = RequestMethod.GET, value = "/inventory-failover")
  ResponseEntity<List<BookInventoryDto>> getOnhandInventory();
}
