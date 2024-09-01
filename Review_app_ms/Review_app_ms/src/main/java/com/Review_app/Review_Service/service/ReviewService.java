package com.Review_app.Review_Service.service;

import com.Review_app.Review_Service.model.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReview(Long companyId);
    boolean createReview(Long companyId, Review review);
    Review getReviewById(Long reviewId);
    boolean updateReview(Long reviewId, Review updatedReview);
    boolean deleteReviewById(Long reviewId);

}
