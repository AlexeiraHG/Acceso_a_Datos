package Excepciones;


import Excepciones.myException.myException;

public class MainExcepciones {
    public static void main(String[] args) {


        try {
            throw new myException("La opción 4 no esta disponible");
        } catch (myException e) {
            System.out.println(e.getMessage());
        }


//        try {
//            UncheckedTwoExceptions(false);
//        } catch (ArithmeticException e) {
//            System.out.println(e.getMessage());
//        } catch (RuntimeException e) {
//            System.out.println(e.getMessage());
//        }

//        try {
//            UncheckedTwoExceptions(false);
//        }catch (ArithmeticException | NullPointerException e) {
//            System.out.println(e.getMessage());
//        }
//
    }



    //Unchecked
    static private void UncheckedTwoExceptions(boolean flag) throws ArithmeticException, NullPointerException  {
        if (flag) {
            throw new ArithmeticException("ArithmeticException");
        } else {
            throw new NullPointerException("Null");
        }
    }

    private static void checkedTwoExcepcions(boolean flag) throws Exception {

        if (flag) {
            throw new Exception("Common exception");
        } else throw  new RuntimeException("RuntimeException");
    }


    private static void finallyException() {
        try {
            checkedExcepcion1();
            System.out.println("example"); //Don't print anything if exception is thrown
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        finally {
            System.out.println("Always executed");
        }
    }

    private static void Exception() {
        double num = 10 / 0;
        System.out.println(num);
    }

    private static  void checkedExcepcion()   {
        
        try {
            throw new Exception("Mensaje");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private static  void checkedExcepcion1()  throws Exception {

            throw new Exception("Exception throw");

        }



    }

