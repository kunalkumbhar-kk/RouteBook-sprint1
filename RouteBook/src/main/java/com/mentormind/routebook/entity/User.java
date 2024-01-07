package com.mentormind.routebook.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

   
    @Column(unique = true ,nullable=false)
    @NotEmpty
    @Size(min=3 , message="Username should have atleast 3 characters!")
    private String username;
    
    @NotNull
    @Size(max=30 , message="Name should have atmost 20 characters!")

    private String name;
    
    @NotNull
    @Column(unique = true)
    @Email
    private String email;
    
    @NotNull
    @NotEmpty
    @Size(min=8 , message="Password should have atleast 3 characters!")

    private String password;
    
    @NotNull
    @Column(unique = true)
    @NotEmpty
    private String contact;
    
    @NotNull
    @NotEmpty
    private String token;
    
    @NotNull
    @NotEmpty
    private String role;

public User() {}

//In User entity
@OneToMany (mappedBy = "user" ) //, cascade = CascadeType.ALL
//@JsonManagedReference("user-reviews") // Forward reference
@JsonIgnore
private List<Review> reviews;

//In User entity
@OneToMany (mappedBy = "user") //, cascade = CascadeType.ALL
//@JsonManagedReference("user-favourites") // Forward reference
@JsonIgnore
private List<Favourite> favourites;

//In User entity
@OneToMany (mappedBy = "user" ) //, cascade = CascadeType.ALL
//@JsonManagedReference("user-routes") // Forward reference
@JsonIgnore

private List<Route> routes;

public User(int userId, String username, String name, String email, String password, String contact, String token,
		String role, List<Review> reviews, List<Favourite> favourites, List<Route> routes) {
	super();
	this.userId = userId;
	this.username = username;
	this.name = name;
	this.email = email;
	this.password = password;
	this.contact = contact;
	this.token = token;
	this.role = role;
	this.reviews = reviews;
	this.favourites = favourites;
	this.routes = routes;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getContact() {
	return contact;
}

public void setContact(String contact) {
	this.contact = contact;
}

public String getToken() {
	return token;
}

public void setToken(String token) {
	this.token = token;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public List<Review> getReviews() {
	return reviews;
}

public void setReviews(List<Review> reviews) {
	this.reviews = reviews;
}

public List<Favourite> getFavourites() {
	return favourites;
}

public void setFavourites(List<Favourite> favourites) {
	this.favourites = favourites;
}

public List<Route> getRoutes() {
	return routes;
}

public void setRoutes(List<Route> routes) {
	this.routes = routes;
}

@Override
public String toString() {
	return "User [userId=" + userId + ", username=" + username + ", name=" + name + ", email=" + email + ", password="
			+ password + ", contact=" + contact + ", token=" + token + ", role=" + role + ", reviews=" + reviews
			+ ", favourites=" + favourites + ", routes=" + routes + "]";
}

}