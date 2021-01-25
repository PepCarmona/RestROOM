/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.service.restaurantPrivate;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restroom.data.restaurantPrivate.Restaurant;
import restroom.repository.restaurantPrivate.RestaurantRepository;

/**
 *
 * @author PepCarmona
 */
@Service
public class PublicService {
    
    @Autowired
    private RestaurantRepository restaurantRepository;
    
    public List<Restaurant> findAllRestaurants() {
        return (List<Restaurant>) restaurantRepository.findAll();
    }
    
    public Restaurant findRestaurantById(int id) {
        return restaurantRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
