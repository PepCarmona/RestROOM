/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.controller.myapp;

import restroom.data.myapp.Allergen;
import restroom.data.myapp.Food_type;
import restroom.data.myapp.Menu_category;
import restroom.data.myapp.Service;
import restroom.data.myapp.Status;
import restroom.service.myapp.DefaultsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PepCarmona
 */
@RestController
@RequestMapping("/defaults")
public class DefaultsController {
    
    @Autowired
    private DefaultsService defaultsService;
    
    /* Allergens Controller */
    @GetMapping("/allergen/all")
    public List<Allergen> findAllAllergens() {
        return defaultsService.findAllAllergens();
    }
    @GetMapping("/allergen/{id}")
    public Allergen findAllergenById(@PathVariable int id) {
        return defaultsService.findAllergenById(id);
    }
    
    /* Food Types Controller */
    @GetMapping("/food_type/all")
    public List<Food_type> findAllFoodtypes() {
        return defaultsService.findAllFoodtype();
    }
    @GetMapping("/food_type/{id}")
    public Food_type findFoodtypeById(@PathVariable int id) {
        return defaultsService.findFoodtypeById(id);
    }
    
    /* Menu Categories Controller */
    @GetMapping("/menu_category/all")
    public List<Menu_category> findAllMenuCategory() {
        return defaultsService.findAllMenuCategory();
    }
    @GetMapping("/menu_category/{id}")
    public Menu_category findMenuCategoryById(@PathVariable int id) {
        return defaultsService.findMenuCategoryById(id);
    }
    
    /* Services Controller */
    @GetMapping("/service/all")
    public List<Service> findAllServices() {
        return defaultsService.findAllServices();
    }
    @GetMapping("/service/{id}")
    public Service findServiceById(@PathVariable int id) {
        return defaultsService.findServiceById(id);
    }
    
    /* Status Controller */
    @GetMapping("/status/all")
    public List<Status> findAllStatus() {
        return defaultsService.findAllStatus();
    }
    @GetMapping("/status/{id}")
    public Status findStatusById(@PathVariable int id) {
        return defaultsService.findStatusById(id);
    }
}
