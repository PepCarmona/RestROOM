/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.data.myapp;

import java.io.Serializable;
import java.sql.Timestamp;
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
public class Customer implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_ID;
    
    private String first_name;
    
    private String last_name;
    
    private String phone;
    
    private String email;
    
    private String username;
    
    private String password;
    
    @Column(nullable = true)
    private String profile;
    
    private Timestamp register_date;
    
    private Timestamp last_login;
    
    @Column(nullable = true)
    private String address;
    
    @Column(nullable = true)
    private String floor;
    
    @Column(nullable = true)
    private String door;
    
    @Column(nullable = true)
    private String city;
    
    private String zip_code;
    
    private String country;

    public Customer() {
    }

    public Customer(int customer_ID, String first_name, String last_name, String phone, String email, String username, String password, String profile, Timestamp register_date, Timestamp last_login, String address, String floor, String door, String city, String zip_code, String country) {
        this.customer_ID = customer_ID;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.profile = profile;
        this.register_date = register_date;
        this.last_login = last_login;
        this.address = address;
        this.floor = floor;
        this.door = door;
        this.city = city;
        this.zip_code = zip_code;
        this.country = country;
    }
    
    public int getCustomer_ID() {
        return customer_ID;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getProfile() {
        return profile;
    }

    public Timestamp getRegister_date() {
        return register_date;
    }

    public Timestamp getLast_login() {
        return last_login;
    }

    public String getAddress() {
        return address;
    }

    public String getFloor() {
        return floor;
    }

    public String getDoor() {
        return door;
    }

    public String getCity() {
        return city;
    }

    public String getZip_code() {
        return zip_code;
    }

    public String getCountry() {
        return country;
    }

}
