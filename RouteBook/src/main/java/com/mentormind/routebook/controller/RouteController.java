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

import com.mentormind.routebook.entity.Route;
import com.mentormind.routebook.service.RouteService;


@RestController
@RequestMapping("/routes")
@CrossOrigin(origins ="http://localhost:4200")

public class RouteController {

 @Autowired
 private RouteService routeService;

 @PostMapping("/create")
 public String createRoute(@RequestBody Route route) {
	 try {
    routeService.createRoute(route);
    return "route created Successfully!!";
	 }
	 catch(Exception e)
	 {
		    return "route  NOT created "+ e.getMessage();

	 }
 }

 @GetMapping("/getbyid/{routeId}")
 public Route getRouteById(@PathVariable int routeId) {
     return routeService.getRouteById(routeId);
 }
 @GetMapping("/all")
 public List<Route> getAllRoutes() {
     return routeService.getAllRoutes();
 }

 @DeleteMapping("/delete/{routeId}")
 public String deleteRoute(@PathVariable int routeId) {
	 try {
     routeService.deleteRoute(routeId);
     return "Route deleted Successfully!!";
	 } catch(Exception e)
	 {
         return "Error deleting route: " + e.getMessage();

	 }
 }
 
 @PutMapping("/update/{routeId}")
 public String updateRoute(@PathVariable int routeId, @RequestBody Route updatedRoute) {
     try {
         Route existingRoute = routeService.getRouteById(routeId);

         if (existingRoute != null) {
             existingRoute.setSource(updatedRoute.getSource());
             existingRoute.setDestination(updatedRoute.getDestination());
             existingRoute.setDescription(updatedRoute.getDescription());

             routeService.updateRoute(existingRoute);
             return "Route updated successfully.";
         } else {
             return "Route not found.";
         }
     } catch (Exception e) {
         return "Error updating route: " + e.getMessage();
     }
 }
 
}
