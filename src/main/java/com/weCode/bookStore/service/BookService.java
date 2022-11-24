package com.weCode.bookStore.service;

import com.weCode.bookStore.dto.BookDto;
import com.weCode.bookStore.model.Book;
import com.weCode.bookStore.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookService {

    private final BookRepository bookRepository;

    private final ModelMapper modelMapper;

    public BookService(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    private Function<Book, BookDto> convertBookModelToBookDto() {
        return book -> modelMapper.map(book, BookDto.class);
    }

    public List<BookDto> getBooks(){
        Iterable<Book> all = bookRepository.findAll();
        return StreamSupport.stream(all.spliterator(), false)
                .map(convertBookModelToBookDto())
                .collect(Collectors.toList());
    }

    public List<BookDto> getBooksByTitle(String bookTitle) {
        List<Book> booksByTitle = bookRepository.findBooksByTitleIgnoreCase(bookTitle);
        return booksByTitle.stream()
                .map(convertBookModelToBookDto())
                .collect(Collectors.toList());
    }

    public BookDto addNewBook(Book book) {
        bookRepository.insert(book);
        return modelMapper.map(book, BookDto.class);
    }

    public BookDto updateBook(Book book){
        Book existingBook = bookRepository.findById(book.getId()).get();
        existingBook.setDescription(book.getDescription());
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        bookRepository.save(book);
        return modelMapper.map(book, BookDto.class);
    }

    public void deleteBook (String bookid){
        bookRepository.deleteById(bookid);
    }
}
