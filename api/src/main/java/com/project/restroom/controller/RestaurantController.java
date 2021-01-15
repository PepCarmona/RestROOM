/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package com.project.restroom.controller;

import com.project.restroom.data.Restaurant;
import com.project.restroom.service.RestaurantService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PepCarmona
 */

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {
    
    @Autowired
    private RestaurantService service;
    
    @GetMapping
    public List<Restaurant> findAll(){
        return service.findAll();
    }
    
    @GetMapping("/{id}")
    public Restaurant findById(@PathVariable int id){
        return service.findById(id);
    }
    
    @PostMapping
    public Restaurant create(@RequestBody Restaurant restaurant){
        return service.save(restaurant);
    }
    
    @PutMapping
    public Restaurant update(@RequestBody Restaurant restaurant){
        return service.save(restaurant);
    }
    
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        service.delete(id);
    }
}
