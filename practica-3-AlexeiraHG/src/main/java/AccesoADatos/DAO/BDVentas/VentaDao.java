package AccesoADatos.DAO.BDVentas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class VentaDao {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction transaction;

    public VentaDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("ventas");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }
}
