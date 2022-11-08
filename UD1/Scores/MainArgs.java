package Scores;

public class MainArgs {

    public static void main(String[] args) {

        String[] Lista = new String[]{"coche", "moto","avion"};
        DoSomething(Lista);
        DoSomething2("camello", "cerdo", "caballo", "perro");

    }

    private static void DoSomething(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i]);
        }
    }

    private static void DoSomething2(String ...args) {
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i]);
        }
    }

}
