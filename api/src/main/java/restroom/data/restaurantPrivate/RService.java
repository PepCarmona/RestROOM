/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.data.restaurantPrivate;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author PepCarmona
 */
@Entity
@Table(name = "service")
public class RService implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int service_ID;
    
    private String name;

    public RService() {
    }

    public RService(int service_ID, String name) {
        this.service_ID = service_ID;
        this.name = name;
    }

    public int getService_ID() {
        return service_ID;
    }

    public String getName() {
        return name;
    }
}
