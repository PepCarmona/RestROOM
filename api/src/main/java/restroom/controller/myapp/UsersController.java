/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.controller.myapp;

import restroom.data.myapp.Customer;
import restroom.data.myapp.Restaurant;
import restroom.service.myapp.UsersService;
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
@RequestMapping("/users")
public class UsersController {
    
    @Autowired
    private UsersService service;
    
    /* Restaurant Controller */
    @GetMapping("/restaurant/all")
    public List<Restaurant> findAllRestaurants(){
        return service.findAllRestaurants();
    }
    @GetMapping("/restaurant/{id}")
    public Restaurant findRestaurantById(@PathVariable int id){
        return service.findRestaurantById(id);
    }
    @PostMapping("/restaurant")
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant){
        return service.saveRestaurant(restaurant);
    }
    @PutMapping("/restaurant")
    public Restaurant updateRestaurant(@RequestBody Restaurant restaurant){
        return service.saveRestaurant(restaurant);
    }
    @DeleteMapping("/restaurant/{id}")
    public void deleteRestaurantById(@PathVariable int id){
        service.deleteRestaurant(id);
    }
    
    /* Customer Controller */
    @GetMapping("/customer/all")
    public List<Customer> findAllCustomers(){
        return service.findAllCustomers();
    }
    @GetMapping("/customer/{id}")
    public Customer findCustomerById(@PathVariable int id){
        return service.findCustomerById(id);
    }
    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody Customer customer){
        return service.saveCustomer(customer);
    }
    @PutMapping("/customer")
    public Customer updateCustomer(@RequestBody Customer customer){
        return service.saveCustomer(customer);
    }
    @DeleteMapping("/customer/{id}")
    public void deleteCustomerById(@PathVariable int id){
        service.deleteCustomer(id);
    }
}
