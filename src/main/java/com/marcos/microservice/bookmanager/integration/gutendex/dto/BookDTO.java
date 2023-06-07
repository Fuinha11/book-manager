package com.marcos.microservice.bookmanager.integration.gutendex.dto;

import com.marcos.microservice.bookmanager.model.Book;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public record BookDTO (
    int id,
    String title,
    String[] subjects,
    List<PersonDTO> authors,
    List<PersonDTO> translators,
    String[] languages,
    Boolean copyright,
    String media_type,
    Object formats,
    int download_count
) {
    public Book toBook() {
        return new Book(
                id,
                title,
                authors.stream().map(PersonDTO::toAuthor).collect(Collectors.toList()),
                Arrays.stream(languages).toList(),
                download_count
        );
    }
}
