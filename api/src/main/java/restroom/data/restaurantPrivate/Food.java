/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.data.restaurantPrivate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
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
public class Food implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_ID")
    private int id;
    
    private String name;
    
    @Column(nullable = true)
    private String description;
    
    private Boolean available;
    
    private float price;
    
    @JoinColumn(name = "category_ID")
    @ManyToOne
    private MenuCategory category;
    
    @JoinColumn(name = "food_type_ID")
    @ManyToOne
    private FoodType foodType;
    
    @ManyToMany(mappedBy = "foods", fetch = FetchType.EAGER)
    private Set<Menu> menus;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "food_allergen",
            joinColumns = {@JoinColumn(name = "food_ID")},
            inverseJoinColumns = {@JoinColumn(name = "allergen_ID")})
    private Set<Allergen> allergens;
    
    public Food() {
    }

    public int getFood_ID() {
        return id;
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

    public MenuCategory getCategory() {
        return category;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public Set<Allergen> getAllergens() {
        return allergens;
    }

    public void setCategory(MenuCategory category) {
        this.category = category;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }
    
    public void addToMenu(Menu menu) {
        
        this.menus.add(menu);
    }
    
    public void setAllergens(Set<Allergen> allergens) {
        this.allergens = allergens;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
