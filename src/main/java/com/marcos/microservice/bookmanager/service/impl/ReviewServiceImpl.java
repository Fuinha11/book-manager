package com.marcos.microservice.bookmanager.service.impl;

import com.marcos.microservice.bookmanager.exception.InvalidRatingException;
import com.marcos.microservice.bookmanager.model.Book;
import com.marcos.microservice.bookmanager.model.Review;
import com.marcos.microservice.bookmanager.model.repository.ReviewRepository;
import com.marcos.microservice.bookmanager.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public Review addReview(Book book, float rating, String review) {
        if (rating < 0 || rating > 5)
            throw new InvalidRatingException();

        return reviewRepository.save( new Review(null, book.id(), rating, review));
    }

    @Override
    public List<Review> getReviewsForBook(Book book) {
        return reviewRepository.findAllByBookId(book.id());
    }
}
