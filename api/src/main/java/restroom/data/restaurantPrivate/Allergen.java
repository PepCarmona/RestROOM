/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.data.restaurantPrivate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Allergen implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "allergen_ID")
    private int id;
    
    private String name;
    
    private String icon_uri;
    
    @ManyToMany(mappedBy = "allergens", fetch = FetchType.EAGER)
    private List<Food> foods;

    public Allergen() {
    }

    public Allergen(String name, String icon_uri) {
        this.name = name;
        this.icon_uri = icon_uri;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIcon_uri() {
        return icon_uri;
    }

    public List<Food> getFoods() {
        return foods;
    }
}
