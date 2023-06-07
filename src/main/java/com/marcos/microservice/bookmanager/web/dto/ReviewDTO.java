package com.marcos.microservice.bookmanager.web.dto;

import com.marcos.microservice.bookmanager.model.Review;
import lombok.Data;

@Data
public class ReviewDTO {
    Integer reviewId;
    int bookId;
    float rating;

    public ReviewDTO(Review review) {
        this.reviewId = review.getReviewId();
        this.bookId = review.getBookId();
        this.rating = review.getRating();
        this.review = review.getReview();
    }

    String review;
}
