/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.data.restaurantPrivate;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
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
@Table(name= "menu", schema= "restaurant_private")
public class Menu implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int menu_ID;
    
    private String name;
    
    @Column(nullable = true)
    private String description;
    
    @Column(nullable = true)
    private Timestamp date_start;
    
    @Column(nullable = true)
    private Timestamp date_finish;
    
    private Boolean available;
    
    public Menu() {
    }

    public Menu(int menu_ID, String name, String description, Timestamp date_start, Timestamp date_finish, Boolean available) {
        this.menu_ID = menu_ID;
        this.name = name;
        this.description = description;
        this.date_start = date_start;
        this.date_finish = date_finish;
        this.available = available;
    }

    public int getMenu_ID() {
        return menu_ID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Timestamp getDate_start() {
        return date_start;
    }

    public Timestamp getDate_finish() {
        return date_finish;
    }

    public Boolean getAvailable() {
        return available;
    }
}
