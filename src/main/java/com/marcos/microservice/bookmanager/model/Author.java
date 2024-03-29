package com.marcos.microservice.bookmanager.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Author(
        String name,
        @JsonAlias("birth_year")
        Integer birthYear,
        @JsonAlias("death_year")
        Integer deathYear
) {
}
