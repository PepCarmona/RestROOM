/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.data.restaurantPrivate;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToOne;

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
    
    @JoinColumn(name = "recipe_ID")
    @OneToOne
    private Recipe recipe;
    
    @JoinColumn(name = "food_type_ID")
    @ManyToOne
    private FoodType foodType;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "menu_item",
            joinColumns = {@JoinColumn(name = "food_ID")},
            inverseJoinColumns = {@JoinColumn(name = "menu_ID")})
    private Set<Menu> menus;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "food_allergen",
            joinColumns = {@JoinColumn(name = "food_ID")},
            inverseJoinColumns = {@JoinColumn(name = "allergen_ID")})
    private Set<Allergen> allergens;
    
    public Food() {
    }

    public Food(String name, String description, Boolean available, float price, MenuCategory category, Recipe recipe, FoodType foodType, List<Integer> allergenIds) {
        this.name = name;
        this.description = description;
        this.available = available;
        this.price = price;
        this.category = category;
        this.recipe = recipe;
        this.foodType = foodType;
        //allergenIds.forEach(allergenId -> this.allergens.add(MenuService.findAllergenById(allergenId)));
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

    public Recipe getRecipe() {
        return recipe;
    }
//    
//    public String getMenus() {
//        return menus;
//    }
//    
//    public ArrayList<Integer> menusToArray() {
//        ArrayList<Integer> menusId = new ArrayList<>();
//        String[] splitted = menus.split(",");
//        for (String split : splitted) {
//            menusId.add(Integer.getInteger(split));
//        }
//        return menusId;
//    }

    public FoodType getFoodType() {
        return foodType;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public Set<Allergen> getAllergens() {
        return allergens;
    }
}
