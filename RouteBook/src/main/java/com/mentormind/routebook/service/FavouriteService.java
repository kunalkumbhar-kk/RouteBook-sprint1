package com.mentormind.routebook.service;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentormind.routebook.entity.Favourite;
import com.mentormind.routebook.repository.FavouriteRepository;

@Service
public class FavouriteService {

 @Autowired
 private FavouriteRepository favouriteRepository;

 public Favourite createFavourite(Favourite favourite) {
     return favouriteRepository.save(favourite);
 }

 public Favourite getFavouriteById(int favId) {
     Optional<Favourite> optionalFavourite = favouriteRepository.findById(favId);
     return optionalFavourite.orElse(null);
 }

 public List<Favourite> getAllFavourites() {
     return favouriteRepository.findAll();
 }

 public void deleteFavourite(int favId) {
     favouriteRepository.deleteById(favId);
 }
 

 
 public Favourite updateFavourite(int favId, Favourite updatedFavourite) {
     try {
         Favourite existingFavourite = favouriteRepository.findById(favId).orElseThrow();

         // Update the fields you want to allow updating
         existingFavourite.setUser(updatedFavourite.getUser());
         existingFavourite.setRoute(updatedFavourite.getRoute());

         return favouriteRepository.save(existingFavourite);
     } catch (NoSuchElementException e) {
    	 System.out.println("Exception is :"+e);
     }
	return updatedFavourite;
 }
}
