package org.example;

import Controles.MiControlador;
import Modelo.Person;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Realizamos nuestro primer CRUD");

        MiControlador miControlador = new MiControlador();

        //dame todas las personas
        //List lista = miControlador.dameTodasLasPersonas();

        Person p = new Person(1100, "lola", "ferrer", "lola@ies.es", "f", "192.145.1.2", 900);
        miControlador.inserta(p);

        //lista.forEach(System.out::println);
    }
}