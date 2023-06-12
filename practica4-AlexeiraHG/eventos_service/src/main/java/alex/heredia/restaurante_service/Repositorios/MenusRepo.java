package alex.heredia.restaurante_service.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import alex.heredia.restaurante_service.Modelo.Menus;

@Repository
public interface MenusRepo extends JpaRepository<Menus, Long> {

}
