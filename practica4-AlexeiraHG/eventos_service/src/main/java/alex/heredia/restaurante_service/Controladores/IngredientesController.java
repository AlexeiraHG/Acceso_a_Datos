package alex.heredia.restaurante_service.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import alex.heredia.restaurante_service.Modelo.Ingredientes;
import alex.heredia.restaurante_service.Servicio.IngredientesService;

@RestController
@RequestMapping("/api/ingredientes")
public class IngredientesController {
    @Autowired
    private IngredientesService ingredienteService;

    @GetMapping("/all")
    public List<Ingredientes> getAllIngredientes() {
        return ingredienteService.selectIngredientes();
    }

    @GetMapping("/{id}")
    public Ingredientes getIngredienteById(@PathVariable Long id) {
        return ingredienteService.getIngredienteById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<?> createIngrediente(@RequestBody Ingredientes ingrediente) {
        Ingredientes obj = ingredienteService.guardarNuevo(ingrediente);
        return new ResponseEntity<Ingredientes>(obj, HttpStatus.OK);
    }

    @PutMapping("/update")
    public Ingredientes updateIngrediente(@RequestBody Ingredientes ingredienteDetails) {
        return ingredienteService.updateIngredientes(ingredienteDetails);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteIngrediente(@PathVariable Long id) {
        ingredienteService.deleteIngredientes(id);
    }
}
