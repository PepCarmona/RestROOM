/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.repository.myapp;

import restroom.data.myapp.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author PepCarmona
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer>{
    
}
