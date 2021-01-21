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
public class Myapp_Food_type implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int food_type_ID; 
    
    private String name;
    
    public Myapp_Food_type() {
    }

    public Myapp_Food_type(String name) {
        this.name = name;
    }

    public int getFood_type_ID() {
        return food_type_ID;
    }

    public String getName() {
        return name;
    }
}
