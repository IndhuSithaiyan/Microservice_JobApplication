package com.Review_Service.service;

import com.Review_Service.model.Review;
import java.util.List;

public interface ReviewService {

    List<Review> getAllReview(Long companyId);
    boolean createReview(Long companyId, Review review);
    Review getReviewById(Long companyId, Long reviewId);
    boolean updateReview(Long companyId, Long reviewId, Review updatedReview);
    boolean deleteReviewById(Long companyId, Long reviewId);

}
