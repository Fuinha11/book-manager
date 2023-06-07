package com.marcos.microservice.bookmanager.service;

import com.marcos.microservice.bookmanager.model.Book;
import com.marcos.microservice.bookmanager.model.Review;

public interface ReviewService {
    Review addReview(Book book, float rating, String review);
}
