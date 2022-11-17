package com.weCode.bookStore.controller;

import com.weCode.bookStore.dto.BookDto;
import com.weCode.bookStore.model.Book;
import com.weCode.bookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDto>> getBooks() {
        List<BookDto> books = bookService.getBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{title}")
    public ResponseEntity<List<BookDto>> getBooksByTitle(@PathVariable("title") String title) {
        List<BookDto> booksByTitle = bookService.getBooksByTitle(title);
        return ResponseEntity.ok(booksByTitle);
    }

    @PostMapping
    public ResponseEntity<BookDto> addNewBook(@RequestBody Book book) {
        BookDto newBook = bookService.addNewBook(book);
        return ResponseEntity.status(201).body(newBook);
    }

    @PutMapping
    public ResponseEntity<BookDto> updateBook(@RequestBody Book book){
        BookDto updatedBook = bookService.updateBook(book);
        return ResponseEntity.status(201).body(updatedBook);
    }

    @DeleteMapping("/{bookid}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable String bookid){
        try {
            bookService.deleteBook(bookid);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
