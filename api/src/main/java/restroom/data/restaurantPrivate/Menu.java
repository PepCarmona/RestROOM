/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.data.restaurantPrivate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author PepCarmona
 */
@Entity
@JsonIgnoreProperties({"foods"})
public class Menu implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "menu_ID")
    private int id;
    
    private String name;
    
    @Column(nullable = true)
    private String description;
    
    @Column(nullable = true)
    private Timestamp date_start;
    
    @Column(nullable = true)
    private Timestamp date_finish;
    
    private Boolean available;
    
    @ManyToMany(mappedBy = "menus")
    private List<Food> foods;
    
    public Menu() {
    }

    public Menu(String name, String description, Timestamp date_start, Timestamp date_finish, Boolean available) {
        this.name = name;
        this.description = description;
        this.date_start = date_start;
        this.date_finish = date_finish;
        this.available = available;
    }

    public int getMenu_ID() {
        return id;
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

    public List<Food> getFoods() {
        return foods;
    }
}
