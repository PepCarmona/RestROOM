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
public class Recipe implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipe_ID;
    
    @Column(nullable = true)
    private String instructions;
    
    private float result_quantity;
    
    private int food;

    public Recipe() {
    }

    public Recipe(int recipe_ID, String instructions, float result_quantity, int food) {
        this.recipe_ID = recipe_ID;
        this.instructions = instructions;
        this.result_quantity = result_quantity;
        this.food = food;
    }

    public int getRecipe_ID() {
        return recipe_ID;
    }

    public String getInstructions() {
        return instructions;
    }

    public float getResult_quantity() {
        return result_quantity;
    }

    public int getFood() {
        return food;
    }
}
