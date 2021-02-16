/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.repository.restaurantPrivate;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import restroom.data.restaurantPrivate.Food;

/**
 *
 * @author PepCarmona
 */
public interface FoodRepository extends CrudRepository<Food, Integer>{
    
    /* -------------- MANAGER -------------- */
    
    public List<Food> findByMenus_id(int id);
    
    public List<Food> findByMenus_idAndCategory_id(int menusId, int categoryId);

    
    /* ---------------- DISPLAYER --------------- */
    public List<Food> findByMenus_idAndCategory_idAndAvailableIsTrue(int menuId, int categoryId, Sort sort);
    
    public List<Food> findByMenus_idAndCategory_idAndFoodType_idInAndAvailableIsTrue(
            int menusId, int categoryId, List<Integer> typeId, Sort sort);
    
    public List<Food> findByMenus_idAndCategory_idAndAllergens_idNotInAndAvailableIsTrue(
            int menusId, int categoryId, List<Integer> allergenId, Sort sort);
    
    public List<Food> findByMenus_idAndCategory_idAndFoodType_idInAndAllergens_idNotInAndAvailableIsTrue(
            int menusId, int categoryId, List<Integer> typeId, List<Integer> allergenId, Sort sort);
}
