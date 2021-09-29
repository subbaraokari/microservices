package com.ust.bookservice.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Version;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {
  @Null
  private UUID id;
  @Version
  private Integer version;
  @Null
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss",shape = JsonFormat.Shape.STRING)
  private OffsetDateTime createdDate;
  @Null
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss",shape = JsonFormat.Shape.STRING)
  private OffsetDateTime lastModifiedDate;
  @NotBlank
  private String bookName;
  @NotNull
  private BookEnum bookType;
  @NotNull
  private String isbn;
  @NotNull
  @Positive
  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private BigDecimal price;
  private Integer quantityOnHand;
}
