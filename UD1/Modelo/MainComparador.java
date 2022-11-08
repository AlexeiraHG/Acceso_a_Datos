package Modelo;

import java.util.*;

public class MainComparador {

    public static void main(String[] args) {
        Persona p1 = new Persona(20, "Pepe");
        Persona p2 = new Persona(18, "Ana");
        Persona p3 = new Persona(25, "Luis");
        Persona p4 = new Persona(30, "Vivas");

        System.out.println("Comparable");
        List<Persona> Lista = new ArrayList<>();
        Lista.add(p1);
        Lista.add(p2);
        Lista.add(p3);
        Lista.add(p4);

        Collections.sort(Lista);

        for (Persona p : Lista) System.out.println(p);

        Collections.sort(Lista);
        System.out.println("ordenado");
        for (Persona p : Lista) System.out.println(p);

        System.out.println("Usando interfaz comparator");
        PersonaNombreComparator pComparator = new PersonaNombreComparator();
        Collections.sort(Lista, pComparator); for (Persona p : Lista) System.out.println(p);


        System.out.println("Con programación Funcional, lambda");
        Comparator<Persona> viejuno = (v1, v2)  -> Integer.compare(v1.getEdad(), v2.getEdad());
        Persona p5 = new Persona(85, "Antonio");
        Lista.add(p5);
        Collections.sort(Lista, viejuno);
        //for (Persona p : Lista) System.out.println(p);
        Lista.stream().forEach(System.out::println); //Primer ejercicio de los que mandó






        System.out.println("Lista");
        Instrumento i1 = new Instrumento("cuerda", "guitarra", 45);
        Instrumento i2 = new Instrumento("Percusion", "bateria", 96);
        Instrumento i3 = new Instrumento("cuerda", "guitarra", 45);

        //Array simple
        List<Instrumento> array = new ArrayList<>();
        array.add(i1);
        array.add(i2);
        array.add(i3);
        array.forEach(System.out::println);

        //TreeSet para eliminar duplicados habiendo implementado el equal hash en la clase
        System.out.println("Treeset");
        TreeSet<Instrumento> treeset = new TreeSet<>();
        treeset.add(i1);
        treeset.add(i2);
        treeset.add(i3);
        treeset.forEach(System.out::println);

        //TreeMap para acceder por identificadores
        System.out.println("TreeMap");
        TreeMap<Integer, Instrumento> map = new TreeMap<>();
        map.put(1, i1);
        map.put(2, i2);
        map.put(3, i3);

        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));


    }
}