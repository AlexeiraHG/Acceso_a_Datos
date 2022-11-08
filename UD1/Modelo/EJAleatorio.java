package Modelo;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class EJAleatorio {

    public static void escribirEnteros() {
        Scanner sc = new Scanner(System.in);
        RandomAccessFile fichero = null;
        int num;

        try {
            fichero = new RandomAccessFile("enteros.dat", "rw");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Introduce un número");
        num = sc.nextInt();
        try {
            fichero.seek(fichero.length());
            fichero.writeInt(num);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fichero != null) {
                try {
                    fichero.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void leerEntero() {
        RandomAccessFile fichero = null;


        try {
            fichero = new RandomAccessFile("enteros.dat", "rw");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int num;

        //Mostrar Ficher
        try {
            fichero.seek(0);
            while (true) {
                num = fichero.readInt();
                System.out.println(num);
            }
        } catch (EOFException e) {
            System.out.println("Fin fichero");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void ModificarEnteros(){
        Scanner sc = new Scanner(System.in);
        RandomAccessFile fichero = null;
        int pos, num;
        long size;

        try {
            fichero = new RandomAccessFile("enteros.dat", "rw");
            size = fichero.length();
            size = size/4;
            System.out.println("El fichero tiene: " + size + " enteros");

            //Modifica el entero que se encuetnra en la posicion
            do {
                System.out.println("Introduce la posición (>= 1 y <=" + size);
                pos = sc.nextInt();
            }while (pos < 1 || pos > size);{
                pos--;
                //nos situamos en la posición
                fichero.seek(pos * 4);
                System.out.println("El valor actual: " + fichero.readInt());
                System.out.println("Introduce el nuevo valor: ");
                num = sc.nextInt();
                fichero.seek(pos * 4);
                fichero.writeInt(num);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}



















