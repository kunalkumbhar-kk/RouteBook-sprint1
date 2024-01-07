package com.mentormind.routebook.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentormind.routebook.entity.Review;
import com.mentormind.routebook.repository.ReviewRepository;


@Service
public class ReviewService {

 @Autowired
 private ReviewRepository reviewRepository;

 public Review createReview(Review review) {
     return reviewRepository.save(review);
 }


 public Review getReviewById(int reviewId) {
     Optional<Review> optionalReview = reviewRepository.findById(reviewId);
     return optionalReview.orElse(null);
 }


 public List<Review> getAllReviews() {
     return reviewRepository.findAll();
 }

 public void deleteReview(int reviewId) {
     reviewRepository.deleteById(reviewId);
 }
 
//Update review details
 public Review updateReview(Review updatedReview) {
     // You can add additional validation or business logic here if needed
     return reviewRepository.save(updatedReview);
 }

}
