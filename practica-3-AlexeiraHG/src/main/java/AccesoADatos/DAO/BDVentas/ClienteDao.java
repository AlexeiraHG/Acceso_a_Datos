package AccesoADatos.DAO.BDVentas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ClienteDao {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction transaction;

    public ClienteDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("ventas");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }
}
