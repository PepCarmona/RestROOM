/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.data.restaurantPrivate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author PepCarmona
 */
@Entity
@Table(name = "food_type")
@JsonIgnoreProperties({"foods"})
public class FoodType implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_type_ID")
    private int id; 
    
    private String name;
    
    @OneToMany(mappedBy = "foodType")
    private List<Food> foods;
    
    public FoodType() {
    }

    public FoodType(String name) {
        this.name = name;
    }

    public int getFood_type_ID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Food> getFoods() {
        return foods;
    }
}
