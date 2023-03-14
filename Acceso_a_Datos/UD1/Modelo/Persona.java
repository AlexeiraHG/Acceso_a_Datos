package Modelo;

public class Persona implements Comparable<Persona>{
    public Persona( int edad, String nombre) {
        this.Nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "edad=" + edad +
                ", Nombre='" + Nombre + '\'' +
                '}';
    }

    int edad;
    String Nombre;

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    //Devolver 0 si son iguales
    //Devolver 1 si this > que el argumento
    //Devolver -1 si el objeto pasado por el argumento es mayor que this
    @Override
    public int compareTo(Persona o) {
//        if (this.edad == o.edad) return 0;
//        else if (this.edad > o.edad) return 1;
//        else return -1;

        return Integer.compare(this.edad, o.edad);
    }
}
