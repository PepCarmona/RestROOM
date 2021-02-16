/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.service.restaurantPrivate;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import restroom.data.restaurantPrivate.Food;
import restroom.repository.restaurantPrivate.FoodRepository;

/**
 *
 * @author PepCarmona
 */
@Service
public class FoodService {
    
    @Autowired
    private FoodRepository foodRepository;
    
    /* -------------- SORTS -------------- */
    private final Sort sortDefault = Sort.by(Sort.Direction.ASC, "id");
    
    private final Sort sortByPriceAsc = Sort.by(Sort.Direction.ASC, "price");
    
    private final Sort sortByPriceDesc = Sort.by(Sort.Direction.DESC, "price");
    
    /* -------------- MANAGER --------------- */
    public List<Food> findAll() {
        return (List<Food>) foodRepository.findAll();
    }
    
    public Food findById(int id) {
        return foodRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    
    public List<Food> findByMenu(int id) {
        return (List<Food>) foodRepository.findByMenus_id(id);
    }
    
    public List<Food> findByCategoryInMenu(int menuId, int categoryId) {
        return (List<Food>) foodRepository.findByMenus_idAndCategory_id(menuId, categoryId);
    }
    
    public Food save(Food food) {
        return foodRepository.save(food);
    }
    
    public void deleteById(int id) {
        foodRepository.deleteById(id);
    }
    
    /* ------------------- DISPLAYER ------------------ */
    
            /* - No Filter - */
    public List<Food> displayBasic(int menuId, int categoryId) {
        return foodRepository.findByMenus_idAndCategory_idAndAvailableIsTrue(menuId, categoryId, sortDefault);
    }
    public List<Food> displayBasicOrderByPriceAsc(int menuId, int categoryId) {
        return foodRepository.findByMenus_idAndCategory_idAndAvailableIsTrue(menuId, categoryId, sortByPriceAsc);
    }
    public List<Food> displayBasicOrderByPriceDesc(int menuId, int categoryId) {
        return foodRepository.findByMenus_idAndCategory_idAndAvailableIsTrue(menuId, categoryId, sortByPriceDesc);
    }
    
            /* - Filter By Allergen - */ 
    /* -!!!- BUG: filter by allergen when a food has multiple allergen -!!!- */
    public List<Food> displayFilterByAllergen(int menuId, int categoryId, List<Integer> allergenIds) {
        return foodRepository.findByMenus_idAndCategory_idAndAllergens_idNotInAndAvailableIsTrue(menuId, categoryId, allergenIds, sortDefault);
    }
    public List<Food> displayFilterByAllergenOrderByPriceAsc(int menuId, int categoryId, List<Integer> allergenIds) {
        return foodRepository.findByMenus_idAndCategory_idAndAllergens_idNotInAndAvailableIsTrue(menuId, categoryId, allergenIds, sortByPriceAsc);
    }
    public List<Food> displayFilterByAllergensOrderByPriceDesc(int menuId, int categoryId, List<Integer> allergenIds) {
        return foodRepository.findByMenus_idAndCategory_idAndAllergens_idNotInAndAvailableIsTrue(menuId, categoryId, allergenIds, sortByPriceDesc);
    }
    
            /* - Filter By Food Type - */
    public List<Food> displayFilterByType(int menuId, int categoryId, List<Integer> typeIds) {
        return foodRepository.findByMenus_idAndCategory_idAndFoodType_idInAndAvailableIsTrue(menuId, categoryId, typeIds, sortDefault);
    }
    public List<Food> displayFilterByTypeOrderByPriceAsc(int menuId, int categoryId, List<Integer> typeIds) {
        return foodRepository.findByMenus_idAndCategory_idAndFoodType_idInAndAvailableIsTrue(menuId, categoryId, typeIds, sortByPriceAsc);
    }
    public List<Food> displayFilterByTypeOrderByPriceDesc(int menuId, int categoryId, List<Integer> typeIds) {
        return foodRepository.findByMenus_idAndCategory_idAndFoodType_idInAndAvailableIsTrue(menuId, categoryId, typeIds, sortByPriceDesc);
    }
    
            /* - Filter By Food Type And Allergen - */
    public List<Food> displayFilterByTypeAndAllergen(int menuId, int categoryId, List<Integer> typeIds, List<Integer> allergenIds) {
        return foodRepository.findByMenus_idAndCategory_idAndFoodType_idInAndAllergens_idNotInAndAvailableIsTrue(menuId, categoryId, typeIds, allergenIds, sortDefault);
    }
    public List<Food> displayFilterByTypeAndAllergenOrderByPriceAsc(int menuId, int categoryId, List<Integer> typeIds, List<Integer> allergenIds) {
        return foodRepository.findByMenus_idAndCategory_idAndFoodType_idInAndAllergens_idNotInAndAvailableIsTrue(menuId, categoryId, typeIds, allergenIds, sortByPriceAsc);
    }
    public List<Food> displayFilterByTypeAndAllergenOrderByPriceDesc(int menuId, int categoryId, List<Integer> typeIds, List<Integer> allergenIds) {
        return foodRepository.findByMenus_idAndCategory_idAndFoodType_idInAndAllergens_idNotInAndAvailableIsTrue(menuId, categoryId, typeIds, allergenIds, sortByPriceDesc);
    }
}
