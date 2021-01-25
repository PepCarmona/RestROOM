/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.controller.restaurantPrivate;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restroom.data.restaurantPrivate.Allergen;
import restroom.data.restaurantPrivate.FoodType;
import restroom.data.restaurantPrivate.Menu;
import restroom.data.restaurantPrivate.MenuCategory;
import restroom.service.restaurantPrivate.MenuService;

/**
 *
 * @author PepCarmona
 */
@RestController
@RequestMapping("api/menu")
public class MenuController {
    
    @Autowired private MenuService menuService;
    
    @GetMapping("/all")
    public List<Menu> findAllMenus() {
        return menuService.findAllMenus();
    }
        
    @GetMapping("/active")
    public List<Menu> findActiveMenus(){
        return menuService.findActiveMenus();
    }
    
    @GetMapping("/{id}")
    public Menu findMenuById(@PathVariable int id) {
        return menuService.findMenuById(id);
    }
    
    @GetMapping("/category/all")
    public List<MenuCategory> findAllCategories() {
        return menuService.findAllCategories();
    }
    
    @GetMapping("/category/{id}")
    public MenuCategory findCategoryById(@PathVariable int id) {
        return menuService.findCategoryById(id);
    }
    
    @GetMapping("/allergen/all")
    public List<Allergen> findAllAllergens() {
        return menuService.findAllAllergens();
    }
    
    @GetMapping("/allergen/{id}")
    public Allergen findAllergenById(@PathVariable int id) {
        return menuService.findAllergenById(id);
    }
    
    @GetMapping("/foodType/all")
    public List<FoodType> findAllTypes() {
        return menuService.findAllTypes();
    }
    
    @GetMapping("/foodType/{id}")
    public FoodType findTypeById(@PathVariable int id) {
        return menuService.findTypeById(id);
    }
}
