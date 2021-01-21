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
import restroom.data.restaurantPrivate.Food;
import restroom.service.restaurantPrivate.FoodService;

/**
 *
 * @author PepCarmona
 */
@RestController
@RequestMapping("/display/food")
public class FoodDisplayerController {
    
    @Autowired FoodService foodService;
    
    @GetMapping("/m/{menuId}/c/{categoryId}")
    public List<Food> displayBasic(@PathVariable int menuId, @PathVariable int categoryId) {
        return foodService.displayBasic(menuId, categoryId);
    }
    
    @GetMapping("/m/{menuId}/c/{categoryId}/asc")
    public List<Food> displayBasicAsc(@PathVariable int menuId, @PathVariable int categoryId) {
        return foodService.displayBasicOrderByPriceAsc(menuId, categoryId);
    }
    
    @GetMapping("/m/{menuId}/c/{categoryId}/desc")
    public List<Food> displayBasicDesc(@PathVariable int menuId, @PathVariable int categoryId) {
        return foodService.displayBasicOrderByPriceDesc(menuId, categoryId);
    }
    
    @GetMapping("/m/{menuId}/c/{categoryId}/a/{allergenIds}")
    public List<Food> displayFilterAllergens(@PathVariable int menuId, @PathVariable int categoryId, @PathVariable List<Integer> allergenIds) {
        return foodService.displayFilterByAllergen(menuId, categoryId, allergenIds);
    }
    
    @GetMapping("/m/{menuId}/c/{categoryId}/a/{allergenIds}/asc")
    public List<Food> displayFilterAllergensPriceAsc(@PathVariable int menuId, @PathVariable int categoryId, @PathVariable List<Integer> allergenIds) {
        return foodService.displayFilterByAllergenOrderByPriceAsc(menuId, categoryId, allergenIds);
    }
    
    @GetMapping("/m/{menuId}/c/{categoryId}/a/{allergenIds}/desc")
    public List<Food> displayFilterAllergensPriceDesc(@PathVariable int menuId, @PathVariable int categoryId, @PathVariable List<Integer> allergenIds) {
        return foodService.displayFilterByAllergensOrderByPriceDesc(menuId, categoryId, allergenIds);
    }
    
    @GetMapping("/m/{menuId}/c/{categoryId}/t/{typeIds}")
    public List<Food> displayFilterType(@PathVariable int menuId, @PathVariable int categoryId, @PathVariable List<Integer> typeIds) {
        return foodService.displayFilterByType(menuId, categoryId, typeIds);
    }
    
    @GetMapping("/m/{menuId}/c/{categoryId}/t/{typeIds}/asc")
    public List<Food> displayFilterTypePriceAsc(@PathVariable int menuId, @PathVariable int categoryId, @PathVariable List<Integer> typeIds) {
        return foodService.displayFilterByTypeOrderByPriceAsc(menuId, categoryId, typeIds);
    }
    
    @GetMapping("/m/{menuId}/c/{categoryId}/t/{typeIds}/desc")
    public List<Food> displayFilterTypePriceDesc(@PathVariable int menuId, @PathVariable int categoryId, @PathVariable List<Integer> typeIds) {
        return foodService.displayFilterByTypeOrderByPriceDesc(menuId, categoryId, typeIds);
    }
    
    @GetMapping("/m/{menuId}/c/{categoryId}/t/{typeIds}/a/{allergenIds}")
    public List<Food> displayFilterTypeAndAllergen(@PathVariable int menuId, @PathVariable int categoryId, @PathVariable List<Integer> typeIds, @PathVariable List<Integer> allergenIds) {
        return foodService.displayFilterByTypeAndAllergen(menuId, categoryId, typeIds, allergenIds);
    }
    
    @GetMapping("/m/{menuId}/c/{categoryId}/t/{typeIds}/a/{allergenIds}/asc")
    public List<Food> displayFilterTypeAndAllergenPriceAsc(@PathVariable int menuId, @PathVariable int categoryId, @PathVariable List<Integer> typeIds, @PathVariable List<Integer> allergenIds) {
        return foodService.displayFilterByTypeAndAllergenOrderByPriceAsc(menuId, categoryId, typeIds, allergenIds);
    }
    
    @GetMapping("/m/{menuId}/c/{categoryId}/t/{typeIds}/a/{allergenIds}/desc")
    public List<Food> displayFilterTypeAndAllergenPriceDesc(@PathVariable int menuId, @PathVariable int categoryId, @PathVariable List<Integer> typeIds, @PathVariable List<Integer> allergenIds) {
        return foodService.displayFilterByTypeAndAllergenOrderByPriceDesc(menuId, categoryId, typeIds, allergenIds);
    }
}
