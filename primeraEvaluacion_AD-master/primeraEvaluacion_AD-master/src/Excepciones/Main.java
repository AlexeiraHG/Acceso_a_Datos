package Excepciones;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Optional<Double> result = averageScore(10.0, 100.0, 3.4, 4.2);
        if (result.isPresent()) {
            System.out.println(result.get());
        } else {
            System.out.println("No result");
        }

        int i = 1;
        //recursive(i);
    }

    private static Optional<Double> averageScore(Double ...scores) {
            if(scores.length == 0){
                return Optional.empty();
            }
            else{
                double sum = 0.0;
                for (Double score : scores) {
                    sum += score;
                }
                    return Optional.of(sum/scores.length);

                }
            }
    private static void recursive(int n) {
        n = n + n;
        recursive(n);

    }
}
