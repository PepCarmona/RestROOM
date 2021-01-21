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

/**
 *
 * @author PepCarmona
 */
@Entity
public class Status implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int status_ID;
    
    private String name;

    public Status() {
    }

    public Status(int status_ID, String name) {
        this.status_ID = status_ID;
        this.name = name;
    }

    public int getStatus_ID() {
        return status_ID;
    }

    public String getName() {
        return name;
    }
}
