package com.marcos.microservice.bookmanager.integration.service;

import com.marcos.microservice.bookmanager.model.Book;

import java.util.List;

public interface GutendexService {
    Book getBookById(int id);
    List<Book> searchBooks(String searchTerm, int page);
}
