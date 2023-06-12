package alex.heredia.restaurante_service.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import alex.heredia.restaurante_service.Modelo.Platos;
import alex.heredia.restaurante_service.Servicio.PlatosService;

@RestController
@RequestMapping("/api/platos")
public class PlatosController {
    @Autowired
    private PlatosService Platoservice;

    @GetMapping("/all")
    public List<Platos> getAllPlatos() {
        return Platoservice.selectPlatos();
    }

    @GetMapping("/{id}")
    public Platos getPlatosById(@PathVariable Long id) {
        return Platoservice.getPlatosById(id);
    }

    @PostMapping("/save")
    public Platos createPlatos(@RequestBody Platos Platos) {
        return Platoservice.guardarNuevo(Platos);
    }

    @PutMapping("/update")
    public Platos updatePlatos(@RequestBody Platos PlatosDetails) {
        return Platoservice.updatePlatos(PlatosDetails);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePlatos(@PathVariable Long id) {
        Platoservice.deletePlatos(id);
    }
}
