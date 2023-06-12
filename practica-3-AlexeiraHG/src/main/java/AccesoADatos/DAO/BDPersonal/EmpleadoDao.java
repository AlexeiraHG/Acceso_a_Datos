package AccesoADatos.DAO.BDPersonal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EmpleadoDao {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction transaction;

    public EmpleadoDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("personal");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    //Insertar empelado


    //Ver empleado y departamento correspondiente

    //Eliminar empleado


}
