package com.marcos.microservice.bookmanager.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record Book(
        int id,
        String title,
        List<Author> authors,
        List<String> languages,
        @JsonAlias("download_count")
        int downloadCount
) {
}
