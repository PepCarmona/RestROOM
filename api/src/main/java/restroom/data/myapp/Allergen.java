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
public class Allergen implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int allergen_ID;
    
    private String name;
    
    private String icon_uri;

    public Allergen() {
    }

    public Allergen(String name, String icon_uri) {
        this.name = name;
        this.icon_uri = icon_uri;
    }

    public int getAllergen_ID() {
        return allergen_ID;
    }

    public String getName() {
        return name;
    }

    public String getIcon_uri() {
        return icon_uri;
    }
}
