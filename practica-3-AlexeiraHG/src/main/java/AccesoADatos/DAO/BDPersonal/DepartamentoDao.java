package AccesoADatos.DAO.BDPersonal;

import AccesoADatos.Modelo.BDPersonal.departamento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DepartamentoDao {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction transaction;

    public DepartamentoDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("personal");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    //Modificar un departamento
    public void update (departamento departamentoOld, departamento departamentoNew ){
        try{
            departamento update = entityManager.find(departamento.class, departamentoOld.getId_dep());
            update.setNombre(departamentoNew.getNombre());
            update.setLocalidad(departamentoNew.getLocalidad());
            transaction.begin();
            entityManager.merge(update);
            transaction.commit();
            System.out.println("departamento actualizado");
        }finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
        }


    }

    //Eliminar un departamento. Previamente, se debe eliminar todos los empleados de dicho
    //departamento. Utiliza una transacción.
    public void borra (departamento dep){

        try{
            transaction.begin();
            departamento aborrar = entityManager.find(departamento.class, dep.getId_dep());
            entityManager.remove(aborrar);
            transaction.commit();
            System.out.println("departamento borrado");
        }finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
        }
    }
    

}
