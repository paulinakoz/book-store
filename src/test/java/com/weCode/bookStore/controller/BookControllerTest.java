package com.weCode.bookStore.controller;

import com.weCode.bookStore.dto.BookDto;
import com.weCode.bookStore.model.Book;
import com.weCode.bookStore.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

    @InjectMocks
    private BookController bookController;

    @MockBean
    private BookService bookService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnBookDtoListWhenGetBooksCalled() {
        List<BookDto> bookDtos = new ArrayList<>();
        bookDtos.add(getBookDto());
        when(bookService.getBooks()).thenReturn(bookDtos);
        ResponseEntity<List<BookDto>> books = bookController.getBooks();
        assertThat(books.getBody()).isNotNull();
        assertThat(books.getBody().size()).isEqualTo(1);
    }

    @Test
    void shouldReturnBookDtoListWhenGetBooksByTitleCalled() {
        List<BookDto> bookDtos = new ArrayList<>();
        bookDtos.add(getBookDto());
        when(bookService.getBooksByTitle(anyString())).thenReturn(bookDtos);
        ResponseEntity<List<BookDto>> books = bookController.getBooksByTitle("test title");
        assertThat(books.getBody()).isNotNull();
        assertThat(books.getBody().size()).isEqualTo(1);
    }


    @Test
    void shouldCreateNewBook() throws Exception {
        BookDto bookDto = getBookDto();
        Book book = getBook();

        when(bookService.addNewBook(any(Book.class))).thenReturn(bookDto);
        ResponseEntity<BookDto> newBook = bookController.addNewBook(book);

        mockMvc.perform(post("http://localhost:8080/api/v1/books").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newBook)))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    void shouldUpdateBook() throws Exception {
        Book book = getBook();
        BookDto updatedBook = getUpdatedBookDto();

        when(bookService.updateBook(any(Book.class))).thenReturn(updatedBook);
        ResponseEntity<BookDto> newBook = bookController.updateBook(book);

        mockMvc.perform(put("http://localhost:8080/api/v1/books").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedBook)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value(updatedBook.getTitle()))
                .andExpect(jsonPath("$.description").value(updatedBook.getDescription()))
                .andDo(print());
    }

    @Test
    void shouldDeleteBook() throws Exception {
        BookDto bookDto = getBookDto();
        String id = bookDto.getId();

        doNothing().when(bookController).deleteBook(id);
        mockMvc.perform(delete("http://localhost:8080/api/v1/books/{id}", id))
                .andExpect(status().isNoContent())
                .andDo(print());
    }

    private BookDto getBookDto() {
        return BookDto.builder()
                .title("test title")
                .description("test description")
                .author("test author")
                .id("test id")
                .releaseYear(2022)
                .build();
    }

    private BookDto getUpdatedBookDto() {
        return BookDto.builder()
                .title("test title 2")
                .description("test description 2")
                .author("test author")
                .id("test id")
                .releaseYear(2022)
                .build();
    }

    private Book getBook() {
        return Book.builder()
                .title("test title")
                .description("test description")
                .author("test author")
                .id("test id")
                .releaseYear(2022)
                .build();
    }
}
