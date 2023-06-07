package com.marcos.microservice.bookmanager.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BooksController {

    @GetMapping("/lol")
    public String lol(){
        return "lol";
    }
}
