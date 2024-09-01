package com.Review_Service.controller;

import com.Review_Service.model.Review;
import com.Review_Service.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company/{companyId}/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllReview(companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createReview(@PathVariable Long companyId, @RequestBody Review review){
        boolean isReviewSaved = reviewService.createReview(companyId, review);
        if (isReviewSaved)
            return new ResponseEntity<>("review added successfully", HttpStatus.CREATED);
        else
            return new ResponseEntity<>("review not saved, company is not exist", HttpStatus.NOT_FOUND);

    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId, @PathVariable Long reviewId){
        Review review = reviewService.getReviewById(companyId, reviewId);
        if (review != null)
            return new ResponseEntity(review, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId,
                                                @RequestBody Review updatedReview){
        boolean updated = reviewService.updateReview(companyId, reviewId, updatedReview);
        if (updated)
            return new ResponseEntity<>("review updated Successfully",HttpStatus.OK);
        return new ResponseEntity<>("review not updated", HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId){
        boolean deleted = reviewService.deleteReviewById(companyId, reviewId);
        if (deleted)
            return new ResponseEntity<>("Review deleted Successfully",HttpStatus.OK);
        return new ResponseEntity<>("Review not found", HttpStatus.NOT_FOUND);
    }


}
