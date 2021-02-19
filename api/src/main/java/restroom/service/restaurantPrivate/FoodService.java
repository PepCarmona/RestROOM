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
}
