package com.weCode.bookStore.controller;

import com.weCode.bookStore.dto.BookDto;
import com.weCode.bookStore.model.Book;
import com.weCode.bookStore.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@WebMvcTest
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturnBookDtoListWhenGetBooksCalled() throws Exception {
        List<BookDto> bookDtos = new ArrayList<>();
        bookDtos.add(getBookDto());
        bookDtos.add(getBookDto());
        when(bookService.getBooks()).thenReturn(bookDtos);

        ResultActions response = mockMvc.perform(get("/api/v1/books"));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",
                        is(bookDtos.size())));
    }

    @Test
    void shouldReturnBookDtoListWhenGetBooksByTitleCalled() throws Exception {
        List<BookDto> bookDtos = new ArrayList<>();
        BookDto bookdto = getBookDto();
        bookDtos.add(bookdto);
        String title = bookdto.getTitle();
        when(bookService.getBooksByTitle(anyString())).thenReturn(bookDtos);

        ResultActions response = mockMvc.perform(get("/api/v1/books/{title}", title));
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$[0].title", is(bookdto.getTitle())))
                .andExpect(jsonPath("$[0].description", is(bookdto.getDescription())))
                .andExpect(jsonPath("$[0].author", is(bookdto.getAuthor())));
    }


    @Test
    void shouldCreateNewBook() throws Exception {
        BookDto bookDto = getBookDto();
        Book book = getBook();

        when(bookService.addNewBook(any(Book.class))).thenReturn(bookDto);

        ResultActions response = mockMvc.perform(post("/api/v1/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book)));

        response.andDo(print()).
                andExpect(status().isCreated())
                .andExpect(jsonPath("$.title", is(book.getTitle())))
                .andExpect(jsonPath("$.description", is(book.getDescription())))
                .andExpect(jsonPath("$.author", is(book.getAuthor())));
    }

    @Test
    void shouldUpdateBook() throws Exception {
        Book book = getBook();
        BookDto updatedBook = getUpdatedBookDto();

        when(bookService.updateBook(book)).thenReturn(updatedBook);

        ResultActions response = mockMvc.perform(put("/api/v1/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedBook)));

        response.andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void shouldDeleteBook() throws Exception {
        BookDto bookDto = getBookDto();
        String id = bookDto.getId();

        willDoNothing().given(bookService).deleteBook(id);
        ResultActions response = mockMvc.perform(delete("/api/v1/books/{id}", id));

        response.andExpect(status().isNoContent())
                .andDo(print());
    }

    private BookDto getBookDto() {
        return BookDto.builder()
                .title("Ikigai")
                .description("The Japanese secret to long and happy life")
                .author("Francesc Miralles")
                .id("1")
                .releaseYear(2018)
                .build();
    }

    private BookDto getUpdatedBookDto() {
        return BookDto.builder()
                .title("Awareness")
                .description("Conversations with the Masters")
                .author("Anthony de Mello")
                .id("2")
                .releaseYear(1990)
                .build();
    }

    private Book getBook() {
        return Book.builder()
                .title("Ikigai")
                .description("The Japanese secret to long and happy life")
                .author("Francesc Miralles")
                .id("1")
                .releaseYear(2018)
                .build();
    }
}
