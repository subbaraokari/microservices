package com.ust.bookinventoryservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookInventoryDto {
  private UUID id;
  private OffsetDateTime createdDate;
  private OffsetDateTime lastModifiedDate;
  private UUID bookId;
  private Integer quantityOnHand;
}
