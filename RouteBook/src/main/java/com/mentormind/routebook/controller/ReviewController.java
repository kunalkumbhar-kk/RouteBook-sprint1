package com.mentormind.routebook.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentormind.routebook.entity.Review;
import com.mentormind.routebook.service.ReviewService;


@RestController
@RequestMapping("/reviews")
@CrossOrigin(origins = "http://localhost:4200")

public class ReviewController {

 @Autowired
 private ReviewService reviewService;

 @PostMapping("/create")
 public Review createReview(@RequestBody Review review) {
     return reviewService.createReview(review);
 }

 @GetMapping("/getreview/{reviewId}")
 public Review getReviewById(@PathVariable int reviewId) {
     return reviewService.getReviewById(reviewId);
 }

 @GetMapping("/all")
 public List<Review> getAllReviews() {
     return reviewService.getAllReviews();
 }

 @DeleteMapping("/delete/{reviewId}")
 public void deleteReview(@PathVariable int reviewId) {
     reviewService.deleteReview(reviewId);
 }
 
//Update review details
 @PutMapping("/update/{reviewId}")
 public Review updateReview(@PathVariable int reviewId, @RequestBody Review updatedReview) {
     try {
         Review existingReview = reviewService.getReviewById(reviewId);

         if (existingReview != null) {
             // Update the fields of the existing review with the new values
             existingReview.setRating(updatedReview.getRating());
             // Update other fields as needed

             // Save the updated review
             return reviewService.updateReview(existingReview);
         } else {
             return null; // Or return an appropriate response for review not found
         }
     } catch (Exception e) {
         // Handle exceptions, log them, and return an error message
         return null; // Or return an appropriate response for the error
     }
 }
}
