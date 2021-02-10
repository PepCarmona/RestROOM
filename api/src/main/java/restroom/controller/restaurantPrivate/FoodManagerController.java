/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.controller.restaurantPrivate;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("api/manage/food")
public class FoodManagerController {
    
    @Autowired private FoodService foodService;
    
    @Autowired private MenuService menuService;
    
    @GetMapping("/all")
    public List<Food> findAllFoods() {
        return foodService.findAll();
    }
    
    @GetMapping("/{id}")
    public Food findFoodById(@PathVariable int id) {
        return foodService.findById(id);
    }
    
    @GetMapping("/menu/{id}")
    public List<Food> findFoodByMenu(@PathVariable int id) {
        return foodService.findByMenu(id);
    }
    
    @GetMapping("/restaurant/{id}")
    public List<Food> findFoodByRestaurant(@PathVariable int id) {
        List<Food> restaurantFoods = new ArrayList<>();
        List<Menu> restaurantMenus = menuService.findMenusByRestaurantId(id);
        restaurantMenus.forEach(restaurantMenu -> {
            restaurantFoods.addAll(restaurantMenu.getFoods());
        });
        return restaurantFoods;
    }
    
    
    @GetMapping("category/{id}")
    public List<Food> findFoodByCategory(@PathVariable int id) {
        return foodService.findByCategory(id);
    }
    
    @GetMapping("/type/{id}")
    public List<Food> findFoodByType(@PathVariable int id) {
        return foodService.findByFoodType(id);
    }
    
    @GetMapping("/recipe/{id}")
    public Food findFoodByRecipe(@PathVariable int id) {
        return foodService.findByRecipe(id);
    }
    
    @GetMapping("/{menuId}/{categoryId}")
    public List<Food> findFoodByCategoryInMenu(@PathVariable int menuId, @PathVariable int categoryId) {
        return foodService.findByCategoryInMenu(menuId, categoryId);
    }
    
    @GetMapping("/{menuId}/{categoryId}/{typeId}")
    public List<Food> findFoodByCategoryInMenuFilterByType(
            @PathVariable int menuId, @PathVariable int categoryId, @PathVariable List<Integer> typeId) {
        return foodService.findByCategoryInMenuFilterByTypes(menuId, categoryId, typeId);
    }
}
