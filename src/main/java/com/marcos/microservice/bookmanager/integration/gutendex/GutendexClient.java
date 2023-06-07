package com.marcos.microservice.bookmanager.integration.gutendex;

import com.marcos.microservice.bookmanager.integration.gutendex.dto.BookDTO;
import com.marcos.microservice.bookmanager.integration.gutendex.dto.GutendexResponse;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Headers("Content-Type: application/json")
@FeignClient(name = "GutendexClient", url = "${gutendex.url}")
public interface GutendexClient {

    @GetMapping(value = "/books/{id}/")
    BookDTO getBook(@PathVariable("id") int id);

    @GetMapping(value = "/books?search={search}&page={page}")
    GutendexResponse searchBooks(
            @PathVariable("search") String search,
            @PathVariable("page") int page
    );
}
