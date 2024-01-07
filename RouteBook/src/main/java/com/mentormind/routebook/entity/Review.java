package com.mentormind.routebook.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int reviewId;

 private int rating;
 
 public Review() {}
 
 @ManyToOne
 //@JoinColumn(name = "user_id", referencedColumnName = "user_id") 
 @JsonBackReference("user-reviews") // Backward reference
 private User user;

 @ManyToOne
// @JoinColumn(name = "route_id", referencedColumnName = "route_id")
@JsonBackReference("route-reviews") // Backward reference
 private Route route;
 
public Review(int reviewId, int rating, User user, Route route) {
	super();
	this.reviewId = reviewId;
	this.rating = rating;
	this.user = user;
	this.route = route;
}
public int getReviewId() {
	return reviewId;
}
public void setReviewId(int reviewId) {
	this.reviewId = reviewId;
}
public int getRating() {
	return rating;
}
public void setRating(int rating) {
	this.rating = rating;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Route getRoute() {
	return route;
}
public void setRoute(Route route) {
	this.route = route;
}
@Override
public String toString() {
	return "Review [reviewId=" + reviewId + ", rating=" + rating + ", user=" + user + ", route=" + route + "]";
}

}