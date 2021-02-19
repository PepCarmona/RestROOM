/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.data.restaurantPrivate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author PepCarmona
 */
@Entity
@JsonIgnoreProperties({"restaurant", "foods"})
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
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "menu_item",
            joinColumns = {@JoinColumn(name = "menu_ID")},
            inverseJoinColumns = {@JoinColumn(name = "food_ID")})
    private Set<Food> foods;
    
    @JoinColumn(name = "restaurant_ID")
    @ManyToOne
    private Restaurant restaurant;
    
    public Menu() {
    }

    public Menu(String name, String description, Timestamp date_start, Timestamp date_finish, Boolean available, Restaurant restaurant) {
        this.name = name;
        this.description = description;
        this.date_start = date_start;
        this.date_finish = date_finish;
        this.available = available;
        this.restaurant = restaurant;
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

    public Set<Food> getFoods() {
        return foods;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setFoods(Set<Food> foods) {
        this.foods = foods;
    }
    
    public void addFood(Food food) {
        this.foods.add(food);
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    
    public void setAvailable(boolean available) {
        this.available = available;
    }
}
