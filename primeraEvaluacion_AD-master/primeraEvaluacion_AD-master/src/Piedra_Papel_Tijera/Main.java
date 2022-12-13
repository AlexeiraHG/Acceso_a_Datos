package Piedra_Papel_Tijera;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;




public class Main {

    static Scanner sc = new Scanner(System.in);
    static String turn = "1";
    static String player1Choice = "";
    static String player2Choice = "";

    static Random rm = new Random();


    static String[] validActions = new String[]{"p", "x", "t"};
    static HashMap<String, String> rockPaperScissors = new HashMap<String, String>();

    public static void main(String[] args) {

        rockPaperScissors.put("p", "piedra");
        rockPaperScissors.put("x", "papel");
        rockPaperScissors.put("t", "tijera");

        String[] gameModeValidValues = new String[]{"j", "m"};
        boolean gameStarted = false;

        System.out.println("Bienvenido a piedra, papel o tijera");

        while (!gameStarted) {

            System.out.println("Desea jugar contra otro jugador(j) o contra la maquina(m)");
            String gameMode = sc.nextLine();

            try{
                valorNoValido(gameMode, gameModeValidValues);
            } catch (valueNotValidException e){
                System.out.println(e.getMessage());
            }

            if (gameMode.equals("j")){
                gameStarted = true;
                gameVersusPlayer();
            }
            if (gameMode.equals("m")){
                gameStarted = true;
                GameVersusPc();
            }
        }

    }

    private static void GameVersusPc() {

        String choice = "";


        if (turn.equals("1")) {
            System.out.println("Jugador " + turn + ": Seleccione piedra(p), papel(x) o tijera(t)");
            choice = sc.nextLine();
            player1Choice = choice;
        } else if(turn.equals("2")){
            choice = validActions[(rm.nextInt(3))];
            System.out.println("El ordenador a seleccionado:" + rockPaperScissors.get(choice));
            player2Choice = choice;
        }
        try {
            valorNoValido(choice, validActions);
        } catch (valueNotValidException e) {
            System.out.println(e.getMessage());
            gameVersusPlayer();
        }
        if (turn.equals("1")){
            System.out.println("Has seleccionado: " + rockPaperScissors.get(player1Choice).toString());
            turn = "2";
            GameVersusPc();
        } else if (turn.equals("2")) {
            comprobarGanador(player1Choice, player2Choice);
        }

    }

    private static void gameVersusPlayer() {
        String choice = "";

        System.out.println("Jugador " + turn + ": Seleccione piedra(p), papel(x) o tijera(t)");
        if (turn.equals("1")) {
            choice = sc.nextLine();
            player1Choice = choice;
        } else if(turn.equals("2")){
            choice = sc.nextLine();
            player2Choice = choice;

        }
        try {
            valorNoValido(choice, validActions);
        } catch (valueNotValidException e) {
            System.out.println(e.getMessage());
            gameVersusPlayer();
        }
        if (turn.equals("1")){
            for (int i = 0; i < 15; i++) {
                System.out.println("\n\n\n\n\n\n\n\n");
            }
            System.out.println("El jugador 1 ya ha seleccionado");
            turn = "2";
            gameVersusPlayer();
        } else if (turn.equals("2")) {
            System.out.println("El jugador 1 ha seleccionado: " + rockPaperScissors.get(player1Choice) + " el jugador 2 ya ha seleccionado: " + rockPaperScissors.get(player2Choice));
            System.out.println("El ganador es: " );
            comprobarGanador(player1Choice, player2Choice);
        }


    }

    private static void comprobarGanador(String player1Choice, String player2Choice) {


        switch (player1Choice) {
            case "p":
                switch (player2Choice) {
                    case "p" -> System.out.print("Empate");
                    case "x" -> System.out.print("Gana jugador 1");
                    case "t" ->  System.out.print("Gana jugador 2");
                }
                break;

            case "x":
                switch (player2Choice) {
                    case "p" -> System.out.print("Gana jugador 1");
                    case "x" -> System.out.print("Empate");
                    case "t" -> System.out.print("Gana jugador 2");
                }
                break;
                case "t":
                    switch (player2Choice) {
                        case "p" -> System.out.print("Gana jugador 2");
                        case "x" -> System.out.print("Gana jugador 1");
                        case "t" -> System.out.print("Empate");
                    }
                break;
        }
    }

    public static void valorNoValido(String valorIntroducido, String[] valoresValidos) throws valueNotValidException {

        int j = 0;
        for (String valoresValido : valoresValidos) {
            if (!valoresValido.equals(valorIntroducido)) {
                j++;
            }
        }
        if (j == valoresValidos.length) {
            throw new valueNotValidException();
        }
    }
}