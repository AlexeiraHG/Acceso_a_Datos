package alex.heredia.restaurante_service.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import alex.heredia.restaurante_service.Modelo.Ordenes;
import alex.heredia.restaurante_service.Servicio.OrdenesService;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenesController {

    @Autowired
    private OrdenesService Ordeneservice;

    @GetMapping("/all")
    public List<Ordenes> getAllOrdenes() {
        return Ordeneservice.selectOrdenes();
    }

    @GetMapping("/{id}")
    public Ordenes getOrdenesById(@PathVariable Long id) {
        return Ordeneservice.getOrdenesById(id);
    }

    @PostMapping("/save")
    public Ordenes createIngrediente(@RequestBody Ordenes ingrediente) {
        return Ordeneservice.guardarNuevo(ingrediente);
    }

    @PutMapping("/update")
    public Ordenes updateIngrediente(@RequestBody Ordenes ordenDetails) {
        return Ordeneservice.updateOrdenes(ordenDetails);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteIngrediente(@PathVariable Long id) {
        Ordeneservice.deleteOrdenes(id);
    }
}
