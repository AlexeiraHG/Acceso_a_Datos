package org.iesch.ad;

import AccesoADatos.DAO.BDPersonal.DepartamentoDao;
import AccesoADatos.DAO.BDPersonal.EmpleadoDao;
import AccesoADatos.Modelo.BDPersonal.departamento;

public class Main {
    public static void main(String[] args) {
        DepartamentoDao departamentoDao = new DepartamentoDao();
        EmpleadoDao empleadoDao  = new EmpleadoDao();

        //update departamento
        departamento depEnBD = departamento.builder().id_dep(1).nombre("Training").localidad("Yangzhuang").build();
        departamento depNuevo = departamento.builder().id_dep(1).nombre("Informática").localidad("Yangzhuang").build();
//        departamentoDao.update(depEnBD, depNuevo);

        //delete departamento
        departamento aBorrar = departamento.builder().id_dep(1).build();
        departamentoDao.borra(aBorrar);

    }


}
