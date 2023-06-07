package com.marcos.microservice.bookmanager.integration.gutendex.dto;

import com.marcos.microservice.bookmanager.model.Author;

public record PersonDTO (
    Integer birth_year,
    Integer death_year,
    String name
) {
    public Author toAuthor() {
        return new Author(
                name,
                birth_year,
                death_year
        );
    }
}
