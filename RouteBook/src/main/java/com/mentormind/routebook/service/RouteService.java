package com.mentormind.routebook.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentormind.routebook.entity.Route;
import com.mentormind.routebook.repository.RouteRepository;


//RouteService.java (Service)
@Service
public class RouteService {

 @Autowired
 private RouteRepository routeRepository;

 public Route createRoute(Route route) {
     return routeRepository.save(route);
 }

 public Route getRouteById(int routeId) {
     Optional<Route> optionalRoute = routeRepository.findById(routeId);
     return optionalRoute.orElse(null);
 }

 public List<Route> getAllRoutes() {
     return routeRepository.findAll();
 }

 public void deleteRoute(int routeId) {
     routeRepository.deleteById(routeId);
 }
 
//Update route details
 public Route updateRoute(Route updatedRoute) {
     // You can add additional validation or business logic here if needed
     return routeRepository.save(updatedRoute);
 }
}
