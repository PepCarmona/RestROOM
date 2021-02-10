/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.service.restaurantPrivate;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restroom.data.restaurantPrivate.Allergen;
import restroom.data.restaurantPrivate.FoodType;
import restroom.data.restaurantPrivate.Menu;
import restroom.data.restaurantPrivate.MenuCategory;
import restroom.repository.restaurantPrivate.AllergenRepository;
import restroom.repository.restaurantPrivate.FoodTypeRepository;
import restroom.repository.restaurantPrivate.MenuCategoryRepository;
import restroom.repository.restaurantPrivate.MenuRepository;

/**
 *
 * @author PepCarmona
 */

@Service
public class MenuService {
    
    @Autowired private MenuRepository menuRepository;
    
    @Autowired private /*static*/  AllergenRepository allergenRepository;
    
    @Autowired private MenuCategoryRepository categoryRepository;
    
    @Autowired private FoodTypeRepository typeRepository;
    
    public List<Menu> findAllMenus() {
        return (List<Menu>) menuRepository.findAll();
    }
    
    public List<Menu> findActiveMenus() {
        return menuRepository.findByAvailableIsTrue();
    }
    
    public List<Menu> findActiveMenusByRestaurantId(int id) {
        return menuRepository.findByRestaurant_idAndAvailableIsTrue(id);
    }
    
    public Menu findMenuById(int id) {
        return menuRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    
    public List<Menu> findMenusByRestaurantId(int id) {
        return menuRepository.findByRestaurant_id(id);
    }
    
    public List<Allergen> findAllAllergens() {
        return (List<Allergen>) allergenRepository.findAll();
    }
    
    public /*static*/ Allergen findAllergenById(int id) {
        return allergenRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    
    
    public List<MenuCategory> findAllCategories() {
        return (List<MenuCategory>) categoryRepository.findAll();
    }
    
    public MenuCategory findCategoryById(int id) {
        return categoryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    
    public List<FoodType> findAllTypes() {
        return (List<FoodType>) typeRepository.findAll();
    }
    public FoodType findTypeById(int id) {
        return typeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
