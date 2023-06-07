package com.marcos.microservice.bookmanager.integration.gutendex.dto;

import java.util.List;

public record GutendexResponse (
    int count,
    String next,
    String previous,
    List<BookDTO> results
) {}
