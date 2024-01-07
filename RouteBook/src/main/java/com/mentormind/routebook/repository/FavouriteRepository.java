package com.mentormind.routebook.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentormind.routebook.entity.Favourite;


@Repository
public interface FavouriteRepository extends JpaRepository <Favourite, Integer> {
	
}
