package com.ust.bookservice.bootstrap;

import com.ust.bookservice.domain.Book;
import com.ust.bookservice.repositories.BookRepository;
import com.ust.bookservice.web.mappers.BookMapper;
import com.ust.bookservice.web.model.BookEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Component
public class BookLoader implements CommandLineRunner {
  public static final String BOOK_1_ISBN = "0631234200036";
  public static final String BOOK_2_ISBN = "0631234300019";
  public static final String BOOK_3_ISBN = "0083783375213";
  private final BookRepository bookRepository;
  private final BookMapper bookMapper;
  @Override
  public void run(String... args) throws Exception {
    if(bookRepository.count()==0){
      loadBooks();
    }
  }
  private void loadBooks() {
    Book b1 = Book.builder()
      .bookName("Java")
      .bookType(BookEnum.TECHNOLOGY.name())
      .minOnHand(12)
      .quantityToOrder(200)
      .price(new BigDecimal("12.95"))
      .isbn(BOOK_1_ISBN)
      .build();
    Book b2 = Book.builder()
      .bookName("politician")
      .bookType(BookEnum.STORY.name())
      .minOnHand(8)
      .quantityToOrder(200)
      .price(new BigDecimal("10.95"))
      .isbn(BOOK_2_ISBN)
      .build();
    Book b3 = Book.builder()
      .bookName("vegetarian")
      .bookType(BookEnum.COOKING.name())
      .minOnHand(10)
      .quantityToOrder(200)
      .price(new BigDecimal("8.95"))
      .isbn(BOOK_3_ISBN)
      .build();
    bookRepository.save(b1);
    bookRepository.save(b2);
    bookRepository.save(b3);
  }
}
