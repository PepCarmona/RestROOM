/*
 *  Este código tiene como única finalidad el uso educativo, dentro del marco 
 *  de las entregas realizadas a LINKIAFP y sus profesores a través de su plataforma digital.
 */
package restroom.service.restaurantPrivate;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restroom.data.restaurantPrivate.Menu;
import restroom.repository.restaurantPrivate.MenuRepository;

/**
 *
 * @author PepCarmona
 */

@Service
public class MenuService {
    
    @Autowired
    private MenuRepository menuRepository;
    
    public List<Menu> findAllMenus() {
        return (List<Menu>) menuRepository.findAll();
    }
}
