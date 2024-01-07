package com.mentormind.routebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mentormind.routebook.entity.User;
import com.mentormind.routebook.service.UserService;

import jakarta.validation.Valid;

import java.util.List;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	// Create a new user
	@PostMapping("/create-user")
	public String createUser(@Valid @RequestBody User user) {

		try {
			userService.createUser(user);
			return "User created successfully.";
		} catch (Exception e) {
			// Handle exceptions, log them, and return an error message
			return "Error deleting user: " + e.getMessage();
		}
	}

	// Get user details by ID
	@GetMapping("get-user/{userId}")
	public User getUserById(@PathVariable int userId) {
		return userService.getUserById(userId);
	}

	// Get all users
	@GetMapping("/all-users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	// Delete user by ID
	@DeleteMapping("/delete-user/{userId}")
	public String deleteUser(@PathVariable int userId) {
		try {
			userService.deleteUser(userId);
			return "User deleted successfully.";
		} catch (Exception e) {
			// Handle exceptions, log them, and return an error message
			return "Error deleting user: " + e.getMessage();
		}
	}
	@PutMapping("/update-user/{userId}")
	public String updateUser(@PathVariable int userId, @RequestBody User updatedUser) {
		try {
			User existingUser = userService.getUserById(userId);

			if (existingUser != null) {
				// Update the fields of the existing user with the new values
				existingUser.setUsername(updatedUser.getUsername());
				existingUser.setName(updatedUser.getName());
				existingUser.setRole(updatedUser.getRole());
				existingUser.setEmail(updatedUser.getEmail());
				existingUser.setPassword(updatedUser.getPassword());
				existingUser.setToken(updatedUser.getPassword());
				existingUser.setContact(updatedUser.getContact());
				// Update other fields as needed

				// Save the updated user
				userService.createUser(existingUser);

				return "User updated successfully.";
			} else {
				return "User not found.";
			}
		} catch (Exception e) {
			// Handle exceptions, log them, and return an error message
			return "Error updating user: " + e.getMessage();

		}
	}

}
