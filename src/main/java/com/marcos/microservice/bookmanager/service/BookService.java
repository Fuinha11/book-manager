package com.marcos.microservice.bookmanager.service;

import com.marcos.microservice.bookmanager.model.Book;

import java.util.List;

public interface BookService {
    Book getBookById(int id);
    List<Book> searchBooks(String searchTerm, int page);
}
