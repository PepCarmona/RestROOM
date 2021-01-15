/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.service.myapp;

import restroom.data.myapp.Customer;
import restroom.data.myapp.Restaurant;
import restroom.repository.myapp.CustomerRepository;
import restroom.repository.myapp.RestaurantRepository;
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
public class UsersService {
    
    @Autowired private RestaurantRepository restaurantRepository;
    
    @Autowired private CustomerRepository customerRepository;
    
    /* Restaurant Service */
    public List<Restaurant> findAllRestaurants() {
        return (List<Restaurant>) restaurantRepository.findAll();
    }
    public Restaurant findRestaurantById(int id) {
        return restaurantRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
    public void deleteRestaurant(int id) {
        restaurantRepository.deleteById(id);
    }
    
    /* Customer Service */
    public List<Customer> findAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }
    public Customer findCustomerById(int id) {
        return customerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }
}
