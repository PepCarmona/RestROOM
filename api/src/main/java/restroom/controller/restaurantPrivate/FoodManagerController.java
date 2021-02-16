/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.controller.restaurantPrivate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
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
    
    // Get Food By Id
    @GetMapping("/")
    public Food findFoodById(@RequestParam int foodId) {
        return foodService.findById(foodId);
    }
    
    // Get Restaurant Foods
    @GetMapping("/restaurant")
    public List<Food> findFoodByRestaurant(@RequestParam int restaurantId) {
        List<Food> restaurantFoods = new ArrayList<>();
        List<Menu> restaurantMenus = menuService.findMenusByRestaurantId(restaurantId);
        restaurantMenus.forEach(restaurantMenu -> {
            restaurantFoods.addAll(restaurantMenu.getFoods());
        });
        return restaurantFoods;
    }
    
    // Get Foods By Menu & Category
    @GetMapping("/menu")
    public List<Food> findFoodByCategoryInMenu(@RequestParam int menuId, 
                                               @RequestParam(value = "categoryId", required = false) Integer categoryId) {
        if (categoryId == null) return foodService.findByMenu(menuId);
        else return foodService.findByCategoryInMenu(menuId, categoryId);
    }
    
    // Post New Food
    @PostMapping("/new")
    public Food create(@RequestBody Food food, @RequestParam(value = "allergenId", required = false) Set<Allergen> allergenIds,
                                               @RequestParam int menuId, @RequestParam int categoryId, @RequestParam int foodTypeId) {
        food.setCategory(menuService.findCategoryById(categoryId));
        food.setFoodType(menuService.findTypeById(foodTypeId));
        food.setMenus(new HashSet<>());
        food.setAllergens(new HashSet<>());
        Menu menu = menuService.findMenuById(menuId);
        menu.addFood(food);
        food.addToMenu(menu);
        if (allergenIds != null) {
            food.setAllergens(allergenIds);
        }
        return foodService.save(food);
    }
    
    // Update existing Food
    @PutMapping("/update")
    public Food updateFood(@RequestBody Food food, @RequestParam int foodId) {
        return foodService.save(food);
    }
    
    // Delete existing Food
    @DeleteMapping("/delete")
    public void deleteFood(@RequestParam int foodId) {
        foodService.deleteById(foodId);
    }
    
    // Filter Foods By Type & Allergens
    @GetMapping("/filter")
    public List<Food> getFilteredFoods (@RequestBody List<Food> foods, 
                                        @RequestParam(value = "foodType", required = false) List<Integer> foodTypeIds,
                                        @RequestParam(value = "allergen", required = false) List<Integer> allergenIds){
        if (foodTypeIds != null) {
            for (Integer id : foodTypeIds) {
                foods = (List<Food>) foods.stream().filter(food -> food.getFoodType().getId() == id);
            }
        }
        if (allergenIds != null) {
            for (Integer id : allergenIds) {
            foods = foods.stream().filter(food -> 
                    !food.getAllergens().stream().map(Allergen::getId).collect(Collectors.toList())
                            .contains(id)).collect(Collectors.toList());
            }
        }
        return foods;
    }
}
