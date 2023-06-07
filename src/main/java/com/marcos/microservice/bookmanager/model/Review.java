package com.marcos.microservice.bookmanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Review {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "review_id", nullable = false, unique = true)
        Integer reviewId;

        @Column(name = "book_id", nullable = false)
        int bookId;

        @Column(name = "rating", nullable = false)
        float rating;

        @Column(name = "review")
        String review;
}
