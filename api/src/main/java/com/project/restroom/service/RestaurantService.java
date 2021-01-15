/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package com.project.restroom.service;

import com.project.restroom.data.Restaurant;
import com.project.restroom.repository.RestaurantRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PepCarmona
 */

@Service
public class RestaurantService {
    
    @Autowired
    private RestaurantRepository repo;
    
    public List<Restaurant> findAll() {
        return (List<Restaurant>) repo.findAll();
    }
    
    public Restaurant findById(int id) {
        return repo.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    
    public Restaurant save(Restaurant restaurant) {
        return repo.save(restaurant);
    }
    
    public void delete(int id) {
        repo.deleteById(id);
    }
}
