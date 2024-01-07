package com.mentormind.routebook.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "favourites")
public class Favourite {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int favId;

 
 

 public Favourite() {}
 
 @ManyToOne
// @JoinColumn(name = "user_id", referencedColumnName = "user_id") 
 //@JsonBackReference("user-favourites") // Backward reference
 private User user;

 @ManyToOne
 //@JoinColumn(name = "route_id", referencedColumnName = "route_id")
 //@JsonBackReference("route-favourites") // Backward reference

 private Route route;

public Favourite(int favId, User user, Route route) {
	super();
	this.favId = favId;
	this.user = user;
	this.route = route;
}

public int getFavId() {
	return favId;
}

public void setFavId(int favId) {
	this.favId = favId;
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
	return "Favourite [favId=" + favId + ", user=" + user + ", route=" + route + "]";
}

 



}
