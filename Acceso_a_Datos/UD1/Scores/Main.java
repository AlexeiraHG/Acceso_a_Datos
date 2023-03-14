package Scores;

import java.util.Optional;


public class Main {
    public static void main(String[] args) {

        Optional<Double> result = averageScore(3, 4, 5);
        if (result.isPresent()){
            System.out.println(result.get());
        }
        else{
            System.out.println("Nothing");
        }

    }

    private static Optional<Double> averageScore(double ...scores) {
        if (scores.length == 0){
            return Optional.empty();
        }
        else{
            double suma = 0;
            for (Double score: scores) suma+= score;
            return  Optional.of(suma/scores.length);
        }
    }
}
