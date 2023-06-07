package com.marcos.microservice.bookmanager.model.repository;

import com.marcos.microservice.bookmanager.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findAllByBookId(int bookId);
}
