package com.weCode.bookStore.service;

import com.weCode.bookStore.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    public List<BookDto> getBooks(){
        return new ArrayList<>();
    }
}
