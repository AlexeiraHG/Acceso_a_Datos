package EJ_ITV;

import java.time.LocalDate;

public class Car {
    //region variables
    static String Matricula;
    static String Marca;
    static String modelo;
    static String combustible;
    static String Titular;
    static LocalDate Fecha_de_caducidad;
    static String Problemas_encontrados;
    // endregion
    public Car(String Matricula, String Marca, String modelo, String combustible, String Titular, LocalDate Fecha_de_caducidad, String Problemas_encontrados) {
        Car.Matricula = Matricula;
        Car.Marca = Marca;
        Car.modelo = modelo;
        Car.combustible = combustible;
        Car.Titular = Titular;
        Car.Fecha_de_caducidad = Fecha_de_caducidad;
        Car.Problemas_encontrados = Problemas_encontrados;
    }

    @Override
    public String toString() {
        return "Car{" +
                "Matricula='" + Matricula + '\'' +
                ", Marca='" + Marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", combustible='" + combustible + '\'' +
                ", Titular='" + Titular + '\'' +
                ", Fecha de caducidad=" + Fecha_de_caducidad +
                ", Problemas encontrados='" + Problemas_encontrados + '\'' +
                '}';
    }




//region geters y seters
    public static String getMatricula() {
        return Matricula;
    }

    public static void setMatricula(String matricula) {
        Matricula = matricula;
    }

    public static String getMarca() {
        return Marca;
    }

    public static void setMarca(String marca) {
        Marca = marca;
    }

    public static String getModelo() {
        return modelo;
    }

    public static void setModelo(String modelo) {
        Car.modelo = modelo;
    }

    public static String getCombustible() {
        return combustible;
    }

    public static void setCombustible(String combustible) {
        Car.combustible = combustible;
    }

    public static String getTitular() {
        return Titular;
    }

    public static void setTitular(String titular) {
        Titular = titular;
    }

    public static LocalDate getFecha_de_caducidad() {
        return Fecha_de_caducidad;
    }

    public static void setFecha_de_caducidad(LocalDate fecha_de_caducidad) {
        Fecha_de_caducidad = fecha_de_caducidad;
    }

    public static String getProblemas_encontrados() {
        return Problemas_encontrados;
    }

    public static void setProblemas_encontrados(String problemas_encontrados) {
        Problemas_encontrados = problemas_encontrados;
    }

//endregion


}
