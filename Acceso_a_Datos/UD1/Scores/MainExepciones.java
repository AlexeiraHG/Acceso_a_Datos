package Scores;

import org.iesh.MiExepcion.Mi_excepcion;

public class MainExepciones {


    public static void main(String[] args) {

        /*try {
            CheckedException2();
            System.out.println("Se vera esto??");//Spoiler: Nunca porque esta despues
            // de lanzar la excepcion lo que lo
            //manda directo a el catch
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println();
            throw new RuntimeException(e);
        } finally {
            System.out.println("Siempre se ejecuta haya error o no");
        }*/

        try {
            throw new Mi_excepcion("Opcion no disponible");
        } catch (Mi_excepcion e) {
            System.out.println(e.getMessage());
            //throw new RuntimeException(e);
        }
    }

    public static void mainExeptions(String[] args) {

        try {
            CheckedTwoException(false);
        }
        //Se va de la mas especifica a la mas general
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void mainUncheckedTwoExeptions(String[] args) {

        /*try {
            UncheckedTwoException(false);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }*/

        try {
            UncheckedTwoException(false);
        } catch (ArithmeticException | NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }

    //Checked Exception
    public static void CheckedException() {
        try {
            throw new Exception("Mensaje");
        } catch (Exception e) {
            System.out.println(e.getMessage());//logica de negocio
        }
    }

    public static void CheckedException2() throws Exception {
        throw new Exception("Excepcion lanzada");
    }

    private static void CheckedTwoException(boolean flag) throws Exception {
        if (flag) {
            throw new Exception("Excepcion común");
        } else throw new RuntimeException();
    }

    //Unchecked Exception
    public static void ExampleArithmeticException() {
        double number = 10 / 0;
        System.out.println(number);
    }

    private static void UncheckedTwoException(boolean flag) throws NullPointerException, ArithmeticException {
        if (flag) {
            throw new ArithmeticException("Aritmetic común");
        } else throw new NullPointerException("Null Pointer");
    }


    //Finally
    public static void FinallyException() throws Exception {
        try {
            CheckedException2();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception();
        } finally {
            System.out.println("End");
        }

    }
}
