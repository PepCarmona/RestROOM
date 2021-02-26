/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.data.restaurantPrivate;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author PepCarmona
 */
@Entity
@Table(name = "restaurants")
public class Restaurant implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_ID")
    private int id;
    
    private String name;
    
    @Column(nullable = true)
    private String description;
    
    private String address;
    
    private String city;
    
    private String country;
    
    private String zip_code;
    
    private String username;
    
    private String password;
    
    private String website;
    
    private String phone;
    
    private String email;
    
    private float rating;
    
    private String profile_photo_uri;
    
    @OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER)
    private Set<Menu> menus;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "restaurant_services",
            joinColumns = {@JoinColumn(name = "restaurant_ID")},
            inverseJoinColumns = {@JoinColumn(name = "service_ID")})
    private Set<RService> services;
    
    public Restaurant() {
        
    }

    public Restaurant(int id, String name, String description, String address, String city, String country, String zip_code, String username, String password, String website, String phone, String email, float rating, String profile_photo_uri) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.city = city;
        this.country = country;
        this.zip_code = zip_code;
        this.username = username;
        this.password = password;
        this.website = website;
        this.phone = phone;
        this.email = email;
        this.rating = rating;
        this.profile_photo_uri = profile_photo_uri;
    }

    public int getId() {
        return id;
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

    public String getWebsite() {
        return website;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public float getRating() {
        return rating;
    }

    public String getProfile_photo_uri() {
        return profile_photo_uri;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public Set<RService> getServices() {
        return services;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }
    
    public void addMenu(Menu menu) {
        this.menus.add(menu);
    }
}
