package com.ust.bookinventoryservice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class BookInventory extends BaseEntity{
  private UUID bookId;
  private String isbn;
  private Integer quantityOnHand=0;
  @Builder
  public BookInventory(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, UUID bookId, String isbn, Integer quantityOnHand) {
    super(id, version, createdDate, lastModifiedDate);
    this.bookId = bookId;
    this.isbn = isbn;
    this.quantityOnHand = quantityOnHand;
  }
}
