package com.ust.bookservice.services.inventory;

import com.ust.bookservice.services.inventory.model.BookInventoryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Profile;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
@Slf4j
@Component
@Profile("!local-discovery")
public class BookInventoryServiceRestTemplateImpl implements BookInventoryService {
  public static final String INVENTORY_PATH = "/api/v1/book/{bookId}/inventory";
  private final RestTemplate restTemplate;
  public BookInventoryServiceRestTemplateImpl(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }
  @Override
  public Integer getOnHandInventory(UUID bookId) {
    log.debug("Calling Inventory Service");
    ResponseEntity<List<BookInventoryDto>> responseEntity = restTemplate
      .exchange("http://localhost:8082" + INVENTORY_PATH, HttpMethod.GET, null,
        new ParameterizedTypeReference<List<BookInventoryDto>>(){}, (Object) bookId);

    //sum from inventory list
    Integer onHand = Objects.requireNonNull(responseEntity.getBody())
      .stream()
      .mapToInt(BookInventoryDto::getQuantityOnHand)
      .sum();

    return onHand;
  }
}
