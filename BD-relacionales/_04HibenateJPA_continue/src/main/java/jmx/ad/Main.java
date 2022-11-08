package jmx.ad;

import jmx.ad.Controlador.MiControlador;
import jmx.ad.modelo.Empleado;

//import javax.persistence.*; peta por que no funciona en hibernate 6
import jakarta.persistence.*; /*Trabaja con hibernate 6*/
import java.util.List;

public class Main {
    public static void main(String[] args) {

        MiControlador miControlador = new MiControlador();

//        Empleado e1 = Empleado.builder().nombre("Lola").apellidos("Garcia").dni("74852665W").build();
//        miControlador.insert(e1);
//
//        Empleado e2 = Empleado.builder().nombre("Debiles").apellidos("Vistor").dni("18445968J").id(1).build();
//        Empleado e3 = Empleado.builder().nombre("Fuertes").apellidos("Vistor").dni("18445968J").id(1).build();
//        miControlador.update(e3, e2);
//
//        Empleado empleadoBorrar = Empleado.builder().id(3).build();
//        miControlador.Delete(empleadoBorrar);

        miControlador.Busca(1);

        miControlador.BuscaTodos().forEach(System.out::println);




        miControlador.cierra();


        //region lo de antes
       /* try {
            System.out.println("Select al vuelo");
            Query queryTodosEmpleados = entityManager.createQuery("select e from Empleado e");
            List<Empleado> listaEmpleados = queryTodosEmpleados.getResultList();
            listaEmpleados.forEach(System.out::println);

            System.out.println("inserciones de un objeto en BBDD");

            Empleado empleadotmp = Empleado.builder().dni("18445968J").nombre("Victor").apellidos("Fuertes").build();
        *//*transaction.begin();
        entityManager.persist(empleadotmp);
        transaction.commit();*//*

            //Update
            System.out.println("actualizando el usuario id=2");
            Empleado update = entityManager.find(Empleado.class, 2);
            update.setNombre("Donald");
            update.setApellidos("Pato");
            update.setDni("18445999J");
            transaction.begin();
            entityManager.merge(update);
            transaction.commit();
            System.out.println("Hemos realizado un update");
            //Delete
            System.out.println("Eliminamos el Empleado 2");
            transaction.begin();
            entityManager.remove(update);
            transaction.commit();
            System.out.println("Hemos borrado " + update);


        }finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }*/
        //endregion

    }
}