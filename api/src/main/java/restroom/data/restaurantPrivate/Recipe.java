/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.data.restaurantPrivate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author PepCarmona
 */
@Entity
@JsonIgnoreProperties({"food"})
public class Recipe implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_ID")
    private int id;
    
    @Column(nullable = true)
    private String instructions;
    
    private float result_quantity;
    
    @OneToOne(mappedBy = "recipe")
    private Food food;

    public Recipe() {
    }

    public Recipe(String instructions, float result_quantity) {
        this.instructions = instructions;
        this.result_quantity = result_quantity;
    }

    public int getRecipe_ID() {
        return id;
    }

    public String getInstructions() {
        return instructions;
    }

    public float getResult_quantity() {
        return result_quantity;
    }

    public Food getFood() {
        return food;
    }
}
