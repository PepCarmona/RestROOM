/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package com.project.restroom.repository;

import com.project.restroom.data.Restaurant;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author PepCarmona
 */
public interface RestaurantRepository extends CrudRepository<Restaurant, Integer>{
    
}
