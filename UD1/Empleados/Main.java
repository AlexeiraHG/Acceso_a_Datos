package Empleados;


import Modelo.EJAleatorio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static Empleados.FicheroBinario.testLeerFicheroBinaro;
import static Empleados.FicheroBinario.testEscribirFicheroBinaro;

public class Main {
    public static void main(String[] args) {
//        testEscribirFicheroBinaro();
//        testLeerFicheroBinaro();
//        EJAleatorio.escribirEnteros();
//        EJAleatorio.leerEntero();
//        EJAleatorio.ModificarEnteros();

        //region Funciones con File y Directory

        File fichero = new File("FicheroBinario.iml");
        File fichero2 = new File("fichero.txt");
        File directorio = new File("src");
        File directorio2 = new File("directorio");

        System.out.println("fichero: " + fichero.exists());
        System.out.println("Directorio: " + directorio.exists());

        System.out.println("es directorio: " + fichero.isDirectory());
        System.out.println("es directorio: " + directorio.isDirectory());

        System.out.println("fichero se puede leer: " + fichero.canRead());
        System.out.println("fichero se puede leer: " + directorio.canRead());

        System.out.println("fichero: " + fichero.getAbsolutePath());
        System.out.println("fichero: " + fichero.getName());
        System.out.println("fichero: " + fichero.getParent());
        System.out.println("Directorio: " + directorio.getParent());


        //Listar archivos en un directorio
        System.out.println("Objetos file dentro de un Array");

        File lista[] = directorio.listFiles();

        for (File f : lista) {
            System.out.println(f);
        }

        //Crear directorio
        System.out.println("Creando directorio. . .");
        System.out.println(directorio2.mkdir());

        //Lista y siltra archivos en un path
        try (Stream<Path> stream = Files.list(Paths.get(System.getProperty("user.home")))) {
            stream.map(String::valueOf)
                    .filter(path -> !path.startsWith("."))
                    .sorted()
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Expresiones regulares en files
        ExpresionesRegular ex = new ExpresionesRegular();
        ExpresionesRegular.run();

        //endregion

    }
}
