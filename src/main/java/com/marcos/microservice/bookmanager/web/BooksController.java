package com.marcos.microservice.bookmanager.web;

import com.marcos.microservice.bookmanager.integration.service.GutendexService;
import com.marcos.microservice.bookmanager.util.StringUtils;
import com.marcos.microservice.bookmanager.web.dto.BookSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    GutendexService service;

    @GetMapping("/search")
    public BookSearchResponse searchBooks(@RequestParam("searchTerm") String searchTerm, @RequestParam(value = "page", required = false) Integer page) {
        if (page == null || page == 0)
            page = 1;
        String sanitised = StringUtils.Sanitise(searchTerm);
        return new BookSearchResponse(service.searchBooks(sanitised,page));
    }
}
