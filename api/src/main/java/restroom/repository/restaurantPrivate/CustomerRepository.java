/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.repository.restaurantPrivate;

import org.springframework.data.repository.CrudRepository;
import restroom.data.restaurantPrivate.Customer;

/**
 *
 * @author PepCarmona
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    
    public Customer findByUsername(String username);
}
