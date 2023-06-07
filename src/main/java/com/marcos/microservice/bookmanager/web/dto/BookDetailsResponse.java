package com.marcos.microservice.bookmanager.web.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.marcos.microservice.bookmanager.model.Author;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BookDetailsResponse {
    int id;
    String title;
    List<Author> authors;
    List<String> languages;
    @JsonAlias("download_count")
    int downloadCount;
    Float rating;
    List<String> reviews;
}
