package alex.heredia.restaurante_service.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import alex.heredia.restaurante_service.Modelo.Menus;
import alex.heredia.restaurante_service.Repositorios.MenusRepo;

@Service
public class MenusService {
    @Autowired
    private MenusRepo iRepo;

    public List<Menus> getAllMenus() {
        return iRepo.findAll();
    }

    public Menus getMenuById(Long id) {
        return iRepo.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Menu"));
    }

    public Menus createMenu(Menus Menu) {
        return iRepo.save(Menu);
    }

    public Menus updateMenus(Menus menus) {
        Menus menuN = iRepo.findById(menus.getId())
                .orElseThrow(() -> new ResourceAccessException("No se pudo actualizar el menú"));
        menuN.setTitulo(menus.getTitulo());
        menuN.setPlatos(menus.getPlatos());
        return iRepo.save(menuN);
    }

    public Menus deleteMenus(Long id) {
        if (iRepo.existsById(id)) {
            Menus result = iRepo.findById(id).get();
            iRepo.deleteById(id);
            return result;
        } else {
            return null;
        }
    }
}
