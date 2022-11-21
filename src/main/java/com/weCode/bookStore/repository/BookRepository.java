package com.weCode.bookStore.repository;

import com.weCode.bookStore.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findBooksByTitle(String title);
    List<Book> findBooksByTitleIgnoreCase(String title);
}