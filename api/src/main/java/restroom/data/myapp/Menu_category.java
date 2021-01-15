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
public class Menu_category implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_ID;
    
    private String name;

    public Menu_category() {
    }

    public Menu_category(int category_ID, String name) {
        this.category_ID = category_ID;
        this.name = name;
    }

    public int getCategory_ID() {
        return category_ID;
    }

    public String getName() {
        return name;
    }
}
