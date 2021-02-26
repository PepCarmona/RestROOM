/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.service.restaurantPrivate;

import java.util.List;
import java.util.Objects;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restroom.data.restaurantPrivate.Customer;
import restroom.data.restaurantPrivate.Restaurant;
import restroom.data.restaurantPrivate.RService;
import restroom.repository.restaurantPrivate.CustomerRepository;
import restroom.repository.restaurantPrivate.RestaurantRepository;
import restroom.repository.restaurantPrivate.RServiceRepository;

/**
 *
 * @author PepCarmona
 */
@Service
public class PublicService {
    
    @Autowired private RestaurantRepository restaurantRepository;
    
    @Autowired private CustomerRepository customerRepository;
    
    @Autowired private RServiceRepository serviceRepository;
    
    public List<Restaurant> findAllRestaurants() {
        return (List<Restaurant>) restaurantRepository.findAll();
    }
    
    public Restaurant findRestaurantById(int id) {
        return restaurantRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    
    public int findRestaurantByUsername(String username) {
        if (restaurantRepository.findByUsername(username) == null) {
            return -1;
        } else {
            return restaurantRepository.findByUsername(username).getId();
        }
    }
    
    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
    
    public Customer findCustomerById(int id) {
        return customerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    
    public int findCustomerByUsername(String username) {
        if (customerRepository.findByUsername(username) == null) {
            return -1;
        } else {
            return customerRepository.findByUsername(username).getCustomer_ID();
        }
    }
    
    public Customer crateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    
    public List<RService> findAllServices() {
        return (List<RService>) serviceRepository.findAll();
    }
}
