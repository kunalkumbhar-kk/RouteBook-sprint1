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

import com.mentormind.routebook.entity.Favourite;
import com.mentormind.routebook.service.FavouriteService;


@RestController
@RequestMapping("/favourites")
@CrossOrigin(origins = "http://localhost:4200")
public class FavouriteController {

 @Autowired
 private FavouriteService favouriteService;

 @PostMapping("/create")
 public Favourite createFavourite(@RequestBody Favourite favourite) {
     return favouriteService.createFavourite(favourite);
 }

 @GetMapping("/getbyid/{favId}")
 public Favourite getFavouriteById(@PathVariable int favId) {
     return favouriteService.getFavouriteById(favId);
 }

 @GetMapping("/all")
 public List<Favourite> getAllFavourites() {
     return favouriteService.getAllFavourites();
 }

 @DeleteMapping("/delete/{favId}")
 public void deleteFavourite(@PathVariable int favId) {
     favouriteService.deleteFavourite(favId);
 }
 @PutMapping("/update/{favId}")
 public Favourite updateFavourite(@PathVariable int favId, @RequestBody Favourite updatedFavourite) {
     return favouriteService.updateFavourite(favId, updatedFavourite);
 }
}