package com.marcos.microservice.bookmanager.web.dto;

import com.marcos.microservice.bookmanager.model.Book;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class BookSearchResponse {
    List<BookDTO> books;

    public BookSearchResponse(List<Book> books) {
        this.books = books.stream().map(BookDTO::new).collect(Collectors.toList());
    }
}

