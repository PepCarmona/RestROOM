/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.data.myapp;

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
import restroom.data.restaurantPrivate.Food;

/**
 *
 * @author PepCarmona
 */
@Entity
@Table(name = "menu_category", schema = "myapp")
@JsonIgnoreProperties({"foods"})
public class Myapp_Menu_category implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_ID;
    
    @Column(name = "name")
    private String name;

//    @OneToMany(mappedBy = "category")
//    private List<Food> foods;
    
    public Myapp_Menu_category() {
    }

    public Myapp_Menu_category(String name) {
        this.name = name;
    }

    public int getCategory_ID() {
        return category_ID;
    }

    public String getName() {
        return name;
    }

//    public List<Food> getFoods() {
//        return foods;
//    }
}
