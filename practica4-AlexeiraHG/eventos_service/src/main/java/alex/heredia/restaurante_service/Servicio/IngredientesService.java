package alex.heredia.restaurante_service.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alex.heredia.restaurante_service.Excepciones.DatoInexistente;
import alex.heredia.restaurante_service.Modelo.Ingredientes;
import alex.heredia.restaurante_service.Repositorios.IngredientesRepo;

@Service
public class IngredientesService {

    @Autowired
    IngredientesRepo iRepo;

    // Create (C)
    public Ingredientes guardarNuevo(Ingredientes ingredientes) {
        return iRepo.save(ingredientes);
    }

    // Read (R)
    public List<Ingredientes> selectIngredientes() {
        return iRepo.findAll();
    }

    public Ingredientes getIngredienteById(Long id) {
        return iRepo.findById(id)
                .orElseThrow(() -> new DatoInexistente(id));
    }

    // Update (U)
    public Ingredientes updateIngredientes(Ingredientes ingredienteDetails) {
        Ingredientes ingrediente = iRepo.findById(ingredienteDetails.getId())
                .orElseThrow(() -> new DatoInexistente(ingredienteDetails.getId()));
        ingrediente.setNombre(ingredienteDetails.getNombre());
        ingrediente.setCantidad(ingredienteDetails.getCantidad());
        return iRepo.save(ingrediente);
    }

    // Delete (D)
    public Ingredientes deleteIngredientes(Long id) {
        if (iRepo.existsById(id)) {
            Ingredientes result = iRepo.findById(id).get();
            iRepo.deleteById(id);
            return result;
        } else {
            return null;
        }
    }

}
