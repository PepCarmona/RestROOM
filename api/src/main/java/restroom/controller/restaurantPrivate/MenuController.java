/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.controller.restaurantPrivate;

import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import restroom.data.restaurantPrivate.Allergen;
import restroom.data.restaurantPrivate.FoodType;
import restroom.data.restaurantPrivate.Menu;
import restroom.data.restaurantPrivate.MenuCategory;
import restroom.data.restaurantPrivate.Restaurant;
import restroom.service.restaurantPrivate.MenuService;
import restroom.service.restaurantPrivate.PublicService;

/**
 *
 * @author PepCarmona
 */
@RestController
@RequestMapping("api/menu")
public class MenuController {
    
    @Autowired private MenuService menuService;
    
    @Autowired private PublicService publicService;
    
    // Get Menu By Id
    @GetMapping("/")
    public Menu findMenuById(@RequestParam int menuId) {
        return menuService.findMenuById(menuId);
    }
    
    // Get Menus By Restaurant
    @GetMapping("/restaurant")
    public List<Menu> findMenuByRestaurant(@RequestParam int id) {
        return menuService.findMenusByRestaurantId(id);
    }
    
    // Get Active Menus By Restaurant
    @GetMapping("/restaurant/active")
    public List<Menu> findActiveMenusByRestaurant(@RequestParam int id) {
        return menuService.findActiveMenusByRestaurantId(id);
    }
    
    // Post New Menu
    @PostMapping("/new")
    public Menu create(@RequestBody Menu menu, @RequestParam int restaurantId) {
        Restaurant restaurant = publicService.findRestaurantById(restaurantId);
        restaurant.addMenu(menu);
        menu.setRestaurant(restaurant);
        menu.setFoods(new HashSet<>());
        return menuService.save(menu);
    }
    
    @PutMapping("/update")
    public Menu updateMenu(@RequestBody Menu menu, @RequestParam int menuId) {
        return menuService.save(menu);
    }
    
    @DeleteMapping("/delete")
    public void deleteMenu(@RequestParam int menuId) {
        menuService.deleteById(menuId);
    }
    
    // Get All Categories
    @GetMapping("/category/all")
    public List<MenuCategory> findAllCategories() {
        return menuService.findAllCategories();
    }
    
    // Get Category By Id
    @GetMapping("/category")
    public MenuCategory findCategoryById(@RequestParam int id) {
        return menuService.findCategoryById(id);
    }
    
    // Get All Allergens
    @GetMapping("/allergen/all")
    public List<Allergen> findAllAllergens() {
        return menuService.findAllAllergens();
    }
    
    // Get Allergen By Id
    @GetMapping("/allergen")
    public Allergen findAllergenById(@RequestParam int id) {
        return menuService.findAllergenById(id);
    }
    
    // Get All Food Types
    @GetMapping("/foodType/all")
    public List<FoodType> findAllTypes() {
        return menuService.findAllTypes();
    }
    
    // Get Food Type By Id
    @GetMapping("/foodType")
    public FoodType findTypeById(@RequestParam int id) {
        return menuService.findTypeById(id);
    }
}
