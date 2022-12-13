package Excepciones;

public class MainArgs {
    public static void main(String[] args) {

        String[] lista = new String[]{"coche", "moto", "avion"};
       // doSomething(lista);
        doSomething1("camello", "cerdo", "caballo", "perro");
    }

    private static void doSomething(String[] args){//primer ejemplo

        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

    }

    private static void doSomething1(String ...args){//Segundo ejemplo

        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

    }


}
