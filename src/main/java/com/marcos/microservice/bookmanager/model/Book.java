package com.marcos.microservice.bookmanager.model;

import java.util.List;

public record Book(
        int id,
        String title,
        List<Author> authors,
        List<String> languages,
        int downloadCount
) {
}
