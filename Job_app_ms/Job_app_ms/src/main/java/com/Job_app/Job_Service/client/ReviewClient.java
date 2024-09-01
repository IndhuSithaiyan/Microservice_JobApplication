package com.Job_app.Job_Service.client;

import com.Job_app.Job_Service.vo.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "REVIEW-SERVICE")
public interface ReviewClient {

    @GetMapping("/reviews")
    List<Review> getReview(@RequestParam("companyId") Long companyId);
}
