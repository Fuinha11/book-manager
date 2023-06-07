package com.marcos.microservice.bookmanager.service;

import com.marcos.microservice.bookmanager.model.Book;
import com.marcos.microservice.bookmanager.model.Review;

import java.util.List;

public interface ReviewService {
    Review addReview(Book book, float rating, String review);
    List<Review> getReviewsForBook(Book book);
}
