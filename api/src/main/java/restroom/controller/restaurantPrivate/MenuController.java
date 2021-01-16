/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.controller.restaurantPrivate;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restroom.data.restaurantPrivate.Food;
import restroom.data.restaurantPrivate.Menu;
import restroom.service.restaurantPrivate.FoodService;
import restroom.service.restaurantPrivate.MenuService;

/**
 *
 * @author PepCarmona
 */
@RestController
@RequestMapping("restaurantPrivate/menu")
public class MenuController {
    
    @Autowired private MenuService menuService;
    
    @Autowired private FoodService foodService;
    
    @GetMapping("/all")
    public List<Menu> findAll() {
        return menuService.findAllMenus();
    }
    
    @GetMapping("/food")
    public List<Food> findAllFood() {
        return foodService.findAllFoods();
    }
}
