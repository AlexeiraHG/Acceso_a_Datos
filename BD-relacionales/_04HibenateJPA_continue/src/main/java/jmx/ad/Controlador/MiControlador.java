package jmx.ad.Controlador;

import jmx.ad.modelo.Empleado;

//import javax.persistence.*; peta por que no funciona en hibernate 6
import jakarta.persistence.*; /*Trabaja con hibernate 6*/

import java.util.List;

public class MiControlador {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction transaction;

    public MiControlador() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    //Create
    public void insert(Empleado empleado) {
        try {
            transaction.begin();
            entityManager.persist(empleado);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    public void update(Empleado empleadoOld, Empleado empleadoNew) {

        try {
            Empleado update = entityManager.find(Empleado.class, empleadoOld);
            update.setNombre(empleadoNew.getNombre());
            update.setApellidos(empleadoNew.getApellidos());
            update.setDni(empleadoNew.getDni());
            transaction.begin();
            entityManager.merge(update);
            transaction.commit();
            System.out.println("Hemos realizado un update");
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }

    }

    public void Delete(Empleado empleado) {
        try {
            transaction.begin();
            Empleado aborrar = entityManager.find(Empleado.class, empleado.getId());
            entityManager.remove(aborrar);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }


    public Empleado Busca(int id) {
        return entityManager.find(Empleado.class, id);
    }

    public List<Empleado> BuscaTodos() {
        Query queryTodosEmpleados = entityManager.createQuery("select e from Empleado e");
        return queryTodosEmpleados.getResultList();
    }

    public List<Empleado> buscaEmpleadosPorDepartament(String nombreDepartamento) {
        return entityManager.createQuery("Empleado.porDepartamentoNombre", Empleado.class)
                .setParameter(1, nombreDepartamento)
                .getResultList();
    }

    //Close
    public void cierra() {
        entityManager.close();
        entityManagerFactory.close();
    }

}
