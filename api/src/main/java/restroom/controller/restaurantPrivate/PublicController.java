/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.controller.restaurantPrivate;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restroom.data.restaurantPrivate.Restaurant;
import restroom.service.restaurantPrivate.PublicService;

/**
 *
 * @author PepCarmona
 */
@RestController
@RequestMapping("api/public")
public class PublicController {
    
    @Autowired
    private PublicService publicService;
    
    @GetMapping("/restaurant/all")
    public List<Restaurant> findAllRestaurants() {
        return publicService.findAllRestaurants();
    }
    
    @GetMapping("/restaurant/{id}")
    public Restaurant findRestaurantById(@PathVariable int id) {
        return publicService.findRestaurantById(id);
    }
}
