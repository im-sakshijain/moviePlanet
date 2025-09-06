package com.personal.movieplanet.controller;

import com.personal.movieplanet.entity.Review;
import com.personal.movieplanet.dto.ReviewDto;
import com.personal.movieplanet.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/add")
    public void addReview(@RequestBody ReviewDto reviewRequest){
        reviewService.addReview(Review.toEntity(reviewRequest));
    }

    @GetMapping("/find")
    public ReviewDto getReview(@RequestParam Long reviewId){
        return reviewService.getReviewById(reviewId);
    }
}
