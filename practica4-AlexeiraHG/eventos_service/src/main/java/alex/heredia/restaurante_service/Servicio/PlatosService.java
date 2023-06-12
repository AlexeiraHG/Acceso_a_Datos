package alex.heredia.restaurante_service.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import alex.heredia.restaurante_service.Modelo.Platos;
import alex.heredia.restaurante_service.Repositorios.PlatosRepo;

@Service
public class PlatosService {

    @Autowired
    PlatosRepo iRepo;

    // Create (C)
    public Platos guardarNuevo(Platos Platos) {
        return iRepo.save(Platos);
    }

    // Read (R)
    public List<Platos> selectPlatos() {
        return iRepo.findAll();
    }

    public Platos getPlatosById(Long id) {
        return iRepo.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Fallo al obtener platos"));
    }

    // Update (U)
    public Platos updatePlatos(Platos plato) {
        Platos platoN = iRepo.findById(plato.getId())
                .orElseThrow(() -> new ResourceAccessException("No se pudo actualizar el plato"));
        platoN.setNombre(plato.getNombre());
        platoN.setDescripcion(plato.getDescripcion());
        platoN.setIngredientes(plato.getIngredientes());
        return iRepo.save(platoN);
    }

    // Delete (D)
    public Platos deletePlatos(Long id) {
        if (iRepo.existsById(id)) {
            Platos result = iRepo.findById(id).get();
            iRepo.deleteById(id);
            return result;
        } else {
            return null;
        }
    }

}
