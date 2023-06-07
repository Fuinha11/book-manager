package com.marcos.microservice.bookmanager.web.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.marcos.microservice.bookmanager.model.Author;
import com.marcos.microservice.bookmanager.model.Book;
import lombok.Data;

import java.util.List;

@Data
public class BookDTO {
        int id;
        String title;
        List<Author> authors;
        List<String> languages;
        @JsonAlias("download_count")
        int downloadCount;

    public BookDTO(Book book) {
        this.id = book.id();
        this.title = book.title();
        this.authors = book.authors();
        this.languages = book.languages();
        this.downloadCount = book.downloadCount();
    }
}
