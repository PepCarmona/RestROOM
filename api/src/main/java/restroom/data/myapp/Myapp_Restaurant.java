/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.data.myapp;

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
public class Myapp_Restaurant implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int restaurant_ID;
    
    private String name;
    
    @Column(nullable = true)
    private String description;
    
    private String address;
    
    private String city;
    
    private String country;
    
    private String zip_code;
    
    private String username;
    
    private String password;

    public Myapp_Restaurant() {
    }

    public Myapp_Restaurant(String name, String description, String address, String city, String country, String zip_code, String username, String password) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.city = city;
        this.country = country;
        this.zip_code = zip_code;
        this.username = username;
        this.password = password;
    }

    public int getRestaurant_ID() {
        return restaurant_ID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getZip_code() {
        return zip_code;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
}
