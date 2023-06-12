package alex.heredia.restaurante_service.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import alex.heredia.restaurante_service.Modelo.Ordenes;
import alex.heredia.restaurante_service.Repositorios.OrdenesRepo;

@Service
public class OrdenesService {

    @Autowired
    OrdenesRepo iRepo;

    // Create (C)
    public Ordenes guardarNuevo(Ordenes Ordenes) {
        return iRepo.save(Ordenes);
    }

    // Read (R)
    public List<Ordenes> selectOrdenes() {
        return iRepo.findAll();
    }

    public Ordenes getOrdenesById(Long id) {
        return iRepo.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Fallo al obtener Ordenes"));
    }

    // Update (U)
    public Ordenes updateOrdenes(Ordenes Ordenes) {
        Ordenes orden = iRepo.findById(Ordenes.getId())
                .orElseThrow(() -> new ResourceAccessException("No se pudo actualizar la orden"));
        orden.setFecha(Ordenes.getFecha());
        orden.setMesa(Ordenes.getMesa());
        return iRepo.save(orden);
    }

    // Delete (D)
    public Ordenes deleteOrdenes(Long id) {
        if (iRepo.existsById(id)) {
            Ordenes result = iRepo.findById(id).get();
            iRepo.deleteById(id);
            return result;
        } else {
            return null;
        }
    }

}
