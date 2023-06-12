package alex.heredia.restaurante_service.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import alex.heredia.restaurante_service.Modelo.Ordenes;

@Repository
public interface OrdenesRepo extends JpaRepository<Ordenes, Long> {

}
