package com.Review_app.Review_Service.service;

import com.Review_app.Review_Service.model.Review;
import com.Review_app.Review_Service.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReview(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean createReview(Long companyId, Review review) {
        if (companyId != null && review != null){
            review.setCompanyId(companyId);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    @Override
    public boolean updateReview(Long reviewId, Review updatedReview) {
        Optional<Review> review = reviewRepository.findById(reviewId);
        if (review.isPresent()){
            Review review1 = review.get();
            review1.setReviewTitle(updatedReview.getReviewTitle());
            review1.setReviewDescription(updatedReview.getReviewDescription());
            review1.setReviewRating(updatedReview.getReviewRating());
            review1.setCompanyId(updatedReview.getCompanyId());
            reviewRepository.save(review1);

            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReviewById(Long reviewId) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if (reviewId != null){
            reviewRepository.delete(review);
            return true;
        } else {
            return false;
        }
    }
}
