package com.mentormind.routebook.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentormind.routebook.entity.Route;


@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {
}
