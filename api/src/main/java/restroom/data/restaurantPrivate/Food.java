/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.data.restaurantPrivate;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author PepCarmona
 */
@Entity
public class Food implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int food_ID;
    
    private String name;
    
    @Column(nullable = true)
    private String description;
    
    private Boolean available;
    
    private float price;
    
    @Column(name = "category_ID")
    private int category;
    
    @Column(name = "recipe_ID")
    private int recipe;
    
    @Column(name = "food_type_ID")
    private int food_type;

    public Food() {
    }

    public Food(String name, String description, Boolean available, float price, int category, int recipe, int food_type) {
        this.name = name;
        this.description = description;
        this.available = available;
        this.price = price;
        this.category = category;
        this.recipe = recipe;
        this.food_type = food_type;
    }

    public int getFood_ID() {
        return food_ID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public float getPrice() {
        return price;
    }

    public int getCategory() {
        return category;
    }

    public int getRecipe() {
        return recipe;
    }

    public int getFood_type() {
        return food_type;
    }
}
