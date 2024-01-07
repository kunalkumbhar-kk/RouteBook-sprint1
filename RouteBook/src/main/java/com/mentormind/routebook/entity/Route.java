package com.mentormind.routebook.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "routes")
public class Route {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int routeId;

 private String source;
 private String destination;
 private String description;

public Route() {}

@ManyToOne
//@JoinColumn(name = "user_id", referencedColumnName = "user_id") 
//@JsonBackReference("user-routes") // Backward reference

private User user;

@OneToMany
//@JsonManagedReference("route-favourites") // Forward reference
private List<Favourite> favourites;

@OneToMany 
//@JsonManagedReference("route-reviews") // Forward reference
private List<Review> reviews;

public Route(int routeId, String source, String destination, String description, User user, List<Favourite> favourites,
		List<Review> reviews) {
	super();
	this.routeId = routeId;
	this.source = source;
	this.destination = destination;
	this.description = description;
	this.user = user;
	this.favourites = favourites;
	this.reviews = reviews;
}

public int getRouteId() {
	return routeId;
}

public void setRouteId(int routeId) {
	this.routeId = routeId;
}

public String getSource() {
	return source;
}

public void setSource(String source) {
	this.source = source;
}

public String getDestination() {
	return destination;
}

public void setDestination(String destination) {
	this.destination = destination;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public List<Favourite> getFavourites() {
	return favourites;
}

public void setFavourites(List<Favourite> favourites) {
	this.favourites = favourites;
}

public List<Review> getReviews() {
	return reviews;
}

public void setReviews(List<Review> reviews) {
	this.reviews = reviews;
}

@Override
public String toString() {
	return "Route [routeId=" + routeId + ", source=" + source + ", destination=" + destination + ", description="
			+ description + ", user=" + user + ", favourites=" + favourites + ", reviews=" + reviews + "]";
}


}