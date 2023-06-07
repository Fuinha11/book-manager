package com.marcos.microservice.bookmanager.web;

import com.marcos.microservice.bookmanager.model.Book;
import com.marcos.microservice.bookmanager.model.Review;
import com.marcos.microservice.bookmanager.service.BookService;
import com.marcos.microservice.bookmanager.service.ReviewService;
import com.marcos.microservice.bookmanager.util.StringUtils;
import com.marcos.microservice.bookmanager.web.dto.AddReviewRequest;
import com.marcos.microservice.bookmanager.web.dto.BookDetailsResponse;
import com.marcos.microservice.bookmanager.web.dto.BookSearchResponse;
import com.marcos.microservice.bookmanager.web.dto.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/{id}")
    public BookDetailsResponse addReview(@PathVariable("id") int bookId) {
        Book book = bookService.getBookById(bookId);
        List<Review>reviews = reviewService.getReviewsForBook(book);
        return composeBookDetailsResponse(book, reviews);
    }

    private BookDetailsResponse composeBookDetailsResponse(Book book, List<Review> reviews) {
        Float rating = null;
        if (!reviews.isEmpty()) {
            float ratingSum = reviews.stream().map(Review::getRating).reduce(0f, Float::sum);
            rating = ratingSum/reviews.size();
        }
        List<String> reviewList = reviews.stream().map(Review::getReview).collect(Collectors.toList());
        return new BookDetailsResponse(
                book.id(),
                book.title(),
                book.authors(),
                book.languages(),
                book.downloadCount(),
                rating,
                reviewList
        );
    }

    @PostMapping("/{id}/reviews")
    public ReviewDTO addReview(@PathVariable("id") int bookId, @RequestBody AddReviewRequest request) {
        Book book = bookService.getBookById(bookId);
        return new ReviewDTO(reviewService.addReview(book, request.getRating(), StringUtils.Sanitise(request.getReview())));
    }
}
