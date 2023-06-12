package Game;

import java.io.*;
import java.util.*;
import org.apache.log4j.Logger;

public class PiedraPapelTijera {

    public static Logger log = Logger.getLogger(PiedraPapelTijera.class);
    static int playerWins;
    static int computerWins;
    public static String path = "config.properties";
    public static Properties config = new Properties();
    public static String lan;


    public static void main(String[] arg) throws InterruptedException {
        log.info("Implementado el log");
        RockPaperSissors();
    }

    private static void RockPaperSissors() throws InterruptedException {
        playerWins = 0;
        computerWins = 0;

        try {
            config.load(new FileInputStream(path));
        } catch (IOException e) {
            log.error("Fallo al cargar el archivo de configuración");
        }

        lan = config.getProperty("idioma");

        language();

        lan = config.getProperty("idioma");

        if (GameMode()) {
            while (playerWins < 3 && computerWins < 3) {
                playRound();
            }
        } else {
            while (playerWins < 3 && computerWins < 3) {
                playRoundHard();
            }
        }


        if (playerWins > computerWins) {
            System.out.println(config.getProperty("ganaste" + lan));
        } else {
            System.out.println(config.getProperty("perdiste" + lan));
        }


        System.out.println(config.getProperty("jugarDeNuevo" + lan));
        Scanner scanner = new Scanner(System.in);
        try {
            if (scanner.nextLine().equalsIgnoreCase("s") || scanner.nextLine().equalsIgnoreCase("y")) {
                RockPaperSissors();
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void language() {
        System.out.println(config.getProperty("idioma?" + lan));
        Scanner scanner = new Scanner(System.in);
        boolean res = false;
        while (!res) {

            try {
                if (scanner.nextLine().equalsIgnoreCase("es")) {
                    config.setProperty("idioma", "ES");
                    res = true;
                } else if (scanner.nextLine().equalsIgnoreCase("in")) {
                    config.setProperty("idioma", "IN");
                    res = true;
                } else {
                    System.out.println(config.getProperty("intentaIdioma" + lan));
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void playRoundHard() throws InterruptedException {
        int playersHand;
        int computersHand = -1;

        System.out.println(config.getProperty("tiro" + lan));

        Scanner scanner = new Scanner(System.in);
        playersHand = validateHand(scanner);

        if (computerWins == 0 || computerWins == 1 || computerWins == 2) {
            if (playersHand == 0) {
                computersHand = 1;
            } else if (playersHand == 1) {
                computersHand = 2;
            } else if (playersHand == 2) {
                computersHand = 0;
            }
        }

        if (playersHand != -1) {
            printRPSS();
            System.out.println(findEnumHand(playersHand) + " vs " + findEnumHand(computersHand));
            System.out.println(findWinner(playersHand, computersHand) + "\n");
        }
    }

    private static boolean GameMode() {
        System.out.println(config.getProperty("gameMode" + lan));
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equalsIgnoreCase("N")) {
            setPropertyValue(String.valueOf(true));
            return true;
        } else {
            setPropertyValue(String.valueOf(false));
            return false;
        }
    }

    public static void setPropertyValue(String value) {
        try {
            config.setProperty("GameMode", value);
        } catch (Exception e) {
            System.out.println("Error guardando configuración\n" + e.getMessage());
        }
    }

    private static void playRound() throws InterruptedException {
        int playersHand;
        int computersHand = getRandomNumber();

        System.out.println(config.getProperty("tiro" + lan));

        Scanner scanner = new Scanner(System.in);
        playersHand = validateHand(scanner);

        if (playersHand != -1) {
            printRPSS();
            System.out.println(findEnumHand(playersHand) + " vs " + findEnumHand(computersHand));
            System.out.println(findWinner(playersHand, computersHand) + "\n");
        }
    }

    private static void printRPSS() throws InterruptedException {
        System.out.print(config.getProperty("piedra" + lan));
        Thread.sleep(400);
        System.out.print(config.getProperty("papel" + lan));
        Thread.sleep(400);
        System.out.print(config.getProperty("tijeras" + lan));
        Thread.sleep(400);
        System.out.println(config.getProperty("ya" + lan));
        Thread.sleep(400);
    }

    private static int validateHand(Scanner scanner) {
        String input = scanner.nextLine();
        try {
            int i = Integer.parseInt(input);
            if (i >= 1 && i <= 3) {
                return i - 1; // -1 to match the enum values
            } else {
                System.out.println(config.getProperty("intentaNum" + lan));
            }

        } catch (InputMismatchException | NumberFormatException e) {
            if (input.equalsIgnoreCase("q")) {
                System.exit(0);
            }
            System.out.println(config.getProperty("intentaNum" + lan));
        }

        return -1;
    }

    private static String findWinner(int playersHand, int computersHand) {
        String tie = config.getProperty("empate" + lan);
        String win = config.getProperty("gana" + lan);
        String lose = config.getProperty("pierde" + lan);
        String tryAgain = config.getProperty("intentaNum" + lan);
        ArrayList<Integer> availableChoices = new ArrayList<>(Arrays.asList(0, 1, 2));
        ArrayList<Integer> choicesArrayList = new ArrayList<>(availableChoices);

        if (!choicesArrayList.contains(playersHand)) {
            return tryAgain;
        }
        if (playersHand == computersHand) {
            return tie;
        }

        //choicesArrayList.remove(playersHand);

        if ((computersHand == 1 && playersHand == 0) ||
                (playersHand == 1 && computersHand == 2) ||
                (playersHand == 2 && computersHand == 0)) {
            computerWins++;
            return lose;
        } else {
            playerWins++;
            return win;
        }
    }

    private static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(3);
    }

    private static String findEnumHand(int hand) {
        for (Hands h : Hands.values()) {
            if (hand == h.ordinal()) {
                return h.toString();
            }
        }
        return null;
    }
}


