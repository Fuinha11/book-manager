package com.marcos.microservice.bookmanager.web.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddReviewRequest {
    float rating;
    String review;
}
