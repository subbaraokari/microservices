package com.ust.bookservice.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Book {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
  @Type(type = "org.hibernate.type.UUIDCharType")
  @Column(length = 36,columnDefinition = "varchar(36)",nullable = false,updatable = false)
  private UUID id;
  @Version
  private Long version;
  @CreationTimestamp
  @Column(updatable = false)
  private Timestamp createdDate;
  @UpdateTimestamp
  private Timestamp lastModifiedDate;
  private String bookName;
  private String bookType;
  @Column(unique = true)
  private String isbn;
  private BigDecimal price;
  private Integer minOnHand;
  private Integer quantityToOrder;
}
