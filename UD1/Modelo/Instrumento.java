package Modelo;

import java.util.Objects;

public class Instrumento implements Comparable<Instrumento>{

    String tipo;
    String nombre;
    int valor;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }


    public Instrumento(String tipo, String nombre, int valor) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.valor = valor;
    }

    public Instrumento() {
    }

    @Override
    public String toString() {
        return "InstrumentoMusica{" +
                "tipo='" + tipo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", valor=" + valor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instrumento that = (Instrumento) o;
        return valor == that.valor && tipo.equals(that.tipo) && nombre.equals(that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo, nombre, valor);
    }

    @Override
    public int compareTo(Instrumento o) {
        return Integer.compare(this.valor, o.valor);
    }

}
