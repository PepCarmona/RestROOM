/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.data.restaurantPrivate;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
    @Column(name = "service_ID")
    private int id;
    
    private String name;
    
    @ManyToMany(mappedBy = "services", fetch = FetchType.EAGER)
    private Set<Restaurant> restaurants;

    public RService() {
    }

    public RService(int service_ID, String name) {
        this.id = service_ID;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
