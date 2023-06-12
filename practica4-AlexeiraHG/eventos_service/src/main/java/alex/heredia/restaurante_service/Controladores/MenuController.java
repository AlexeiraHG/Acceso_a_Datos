package alex.heredia.restaurante_service.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import alex.heredia.restaurante_service.Modelo.Menus;
import alex.heredia.restaurante_service.Servicio.MenusService;

@RestController
@RequestMapping("/api/menus")
public class MenuController {
    @Autowired
    private MenusService Menuservice;

    @GetMapping("/all")
    public List<Menus> getAllMenus() {
        return Menuservice.getAllMenus();
    }

    @GetMapping("/{id}")
    public Menus getMenuById(@PathVariable Long id) {
        return Menuservice.getMenuById(id);
    }

    @PostMapping("/save")
    public Menus createMenu(@RequestBody Menus Menu) {
        return Menuservice.createMenu(Menu);
    }

    @PutMapping("/update")
    public Menus updateMenu(@RequestBody Menus MenuDetails) {
        return Menuservice.updateMenus(MenuDetails);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMenu(@PathVariable Long id) {
        Menuservice.deleteMenus(id);
    }
}
