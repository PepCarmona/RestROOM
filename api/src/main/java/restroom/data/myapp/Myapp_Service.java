/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.data.myapp;

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
public class Myapp_Service implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int service_ID;
    
    private String name;

    public Myapp_Service() {
    }

    public Myapp_Service(int service_ID, String name) {
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
