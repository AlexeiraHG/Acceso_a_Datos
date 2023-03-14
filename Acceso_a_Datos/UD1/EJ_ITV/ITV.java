package EJ_ITV;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;



public class ITV {
    public static void main(String[] args) {

        List<Car> ITVcars = new ArrayList<>();

        // region Creación autos
        Car c1 = new Car("MEN807",
                "Tesla",
                "A2",
                "Eléctrico",
                "Robert",
                LocalDate.parse("2025-05-03"),
                "null");
        ITVcars.add(c1);

        Car c2 = new Car("ASD785",
                "Honda",
                "Civic",
                "Gasolina",
                "Nani",
                LocalDate.parse("2028-07-01"),
                "Ruedas con poco aire");
        ITVcars.add(c2);
        Car c3 = new Car("HGY521",
                "Tesla",
                "A1",
                "ELéctrico",
                "Diana",
                LocalDate.parse("2023-11-13"),
                "null");

        ITVcars.add(c3);
        Car c4 = new Car("ASD",
                "Toyota",
                "Fiesta",
                "Gasolina",
                "ALexis",
                LocalDate.parse("2022-12-23"),
                "Luz izquierda trasera dañada");

        ITVcars.add(c4);
        Car c5 = new Car("GLO631",
                "Audi",
                "A10",
                "Diesel",
                "Ferrnando",
                LocalDate.parse("2030-12-08"),
                "null");
        ITVcars.add(c5);

        // endregion



//        System.out.println("Ingrese una matricula");
//        Scanner sc = new Scanner(System.in);
//       String matricula = sc.nextLine().toUpperCase();
        String matricula  ="MEN807";

       ITVcars.stream().filter(x -> Car.Matricula.contains("GLO631")).forEach(System.out::println);
//
    }
}
