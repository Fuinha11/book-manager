package com.marcos.microservice.bookmanager.web.dto;

import lombok.Data;

@Data
public class AddReviewRequest {
    float rating;
    String review;
}
