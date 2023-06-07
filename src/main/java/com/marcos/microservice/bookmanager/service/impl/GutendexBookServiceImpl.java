package com.marcos.microservice.bookmanager.service.impl;

import com.marcos.microservice.bookmanager.integration.gutendex.GutendexClient;
import com.marcos.microservice.bookmanager.integration.gutendex.dto.BookDTO;
import com.marcos.microservice.bookmanager.model.Book;
import com.marcos.microservice.bookmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GutendexBookServiceImpl implements BookService {

    @Autowired
    GutendexClient gutendexClient;

    @Override
    public Book getBookById(int id) {
        BookDTO dto = gutendexClient.getBook(id);
        return dto.toBook();
    }

    @Override
    public List<Book> searchBooks(String searchTerm, int page) {
        List<BookDTO> books = gutendexClient.searchBooks(searchTerm, page).results();
        return books.stream().map(BookDTO::toBook).collect(Collectors.toList());
    }
}
