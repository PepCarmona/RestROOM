/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.service.myapp;

import restroom.data.myapp.Allergen;
import restroom.data.myapp.Food_type;
import restroom.data.myapp.Menu_category;
import restroom.data.myapp.Status;
import restroom.repository.myapp.AllergenRepository;
import restroom.repository.myapp.Food_typeRepository;
import restroom.repository.myapp.Menu_categoryRepository;
import restroom.repository.myapp.ServiceRepository;
import restroom.repository.myapp.StatusRepository;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PepCarmona
 */
@Service
public class DefaultsService {
    
    @Autowired private AllergenRepository allergenRepository;
    
    @Autowired private Food_typeRepository foodtypeRepository;
    
    @Autowired private Menu_categoryRepository menucategoryRepository;
    
    @Autowired private ServiceRepository serviceRepository;
    
    @Autowired private StatusRepository statusRepository;
    
    /* Allergens Service */
    public List<Allergen> findAllAllergens() {
        return (List<Allergen>) allergenRepository.findAll();
    }
    public Allergen findAllergenById(int id) {
        return allergenRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    
    /* Food Types Service */
    public List<Food_type> findAllFoodtype() {
        return (List<Food_type>) foodtypeRepository.findAll();
    }
    public Food_type findFoodtypeById(int id) {
        return foodtypeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    
    /* Menu Categories Service */
    public List<Menu_category> findAllMenuCategory() {
        return (List<Menu_category>) menucategoryRepository.findAll();
    }
    public Menu_category findMenuCategoryById(int id) {
        return menucategoryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    
    /* Services Service */
    public List<restroom.data.myapp.Service> findAllServices() {
        return (List<restroom.data.myapp.Service>) serviceRepository.findAll();
    }
    public restroom.data.myapp.Service findServiceById(int id) {
        return serviceRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    
    /* Status Service */
    public List<Status> findAllStatus() {
        return (List<Status>) statusRepository.findAll();
    }
    public Status findStatusById(int id) {
        return statusRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
