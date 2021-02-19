/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.controller.restaurantPrivate;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import restroom.data.restaurantPrivate.Customer;
import restroom.data.restaurantPrivate.Restaurant;
import restroom.data.restaurantPrivate.RService;
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
    
    @GetMapping("/service/all")
    public List<RService> findAllServices() {
        return publicService.findAllServices();
    }
    
    // User login
    @GetMapping("/login")
    public String restaurantLogin (@RequestParam String username, @RequestParam String password) {
        int restaurantId = publicService.findRestaurantByUsername(username);
        int customerId = publicService.findCustomerByUsername(username);
        if (restaurantId == -1 && customerId == -1) {
            return "Username does not exist";
        } else if (restaurantId != -1) {
            Restaurant restaurant = publicService.findRestaurantById(restaurantId);
            if (!password.equals(restaurant.getPassword())) {
                return "Wrong Password";
            } else {
                return "restaurant";
            }
        } else if (customerId != -1) {
            Customer customer = publicService.findCustomerById(customerId);
            if (!password.equals(customer.getPassword())) {
                return "Wrong Password";
            } else {
                customer.setLast_login(new Timestamp(System.currentTimeMillis()));
                return "customer";
            }
        } else {
            return "Something went wrong";
        }
    }
    
    // Register Customer
    @PostMapping("/register/customer")
    public Customer registerCustomer(@RequestBody Customer customer) {
        customer.setRegister_date(new Timestamp(System.currentTimeMillis()));
        customer.setLast_login(new Timestamp(System.currentTimeMillis()));
        return publicService.crateCustomer(customer);
    }
    
    // Register Restaurant
    @PostMapping("/register/restaurant")
    public Restaurant registerRestaurant(@RequestBody Restaurant restaurant) {
        return publicService.createRestaurant(restaurant);
    }
}
