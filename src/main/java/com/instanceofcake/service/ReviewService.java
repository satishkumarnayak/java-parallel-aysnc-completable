package com.instanceofcake.service;

import com.instanceofcake.domain.Review;

import static com.instanceofcake.util.CommonUtil.delay;

public class ReviewService {

    public Review retrieveReviews(String productId) {
        delay(1000);
        return new Review(200, 4.5);
    }
}
