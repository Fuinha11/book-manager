package com.marcos.microservice.bookmanager.web;

import com.marcos.microservice.bookmanager.model.Book;
import com.marcos.microservice.bookmanager.model.Review;
import com.marcos.microservice.bookmanager.service.BookService;
import com.marcos.microservice.bookmanager.service.ReviewService;
import com.marcos.microservice.bookmanager.util.StringUtils;
import com.marcos.microservice.bookmanager.web.dto.AddReviewRequest;
import com.marcos.microservice.bookmanager.web.dto.BookSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    BookService bookService;

    @Autowired
    ReviewService reviewService;

    @GetMapping("/search")
    public BookSearchResponse searchBooks(@RequestParam("searchTerm") String searchTerm, @RequestParam(value = "page", required = false) Integer page) {
        if (page == null || page == 0)
            page = 1;
        String sanitised = StringUtils.Sanitise(searchTerm);
        return new BookSearchResponse(bookService.searchBooks(sanitised,page));
    }

    @PostMapping("/{id}/reviews")
    public Review addReview(@PathVariable("id") int bookId, @RequestBody AddReviewRequest request) {
        Book book = bookService.getBookById(bookId);
        return reviewService.addReview(book, request.getRating(), StringUtils.Sanitise(request.getReview()));
    }
}
