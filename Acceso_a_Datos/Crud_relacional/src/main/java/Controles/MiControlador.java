package Controles;

import Modelo.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MiControlador {
    static final String IP = "127.0.0.1";
    static final String PUERTO = "3306";
    static final String BBDD = "personas";
    static final String USUARIO = "root";
    static final String PASS = "1234";
    static final String CADENA_CONEXION = "jdbc:mysql://" + IP + ":" + PUERTO + "/" + BBDD;

    Connection miConexion;

    public MiControlador() {

        try {
            miConexion = DriverManager.getConnection(CADENA_CONEXION, USUARIO, PASS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //Select * from person
    public List<Person> dameTodasLasPersonas() {
        String sql = "select * from person";
        Statement miStatement = null;
        ResultSet miResultSet;
        ArrayList<Person> miLista = new ArrayList<>();
        try {
            miStatement = miConexion.createStatement();
            miResultSet = miStatement.executeQuery(sql);


            while (miResultSet.next()) {
                Person p = new Person(miResultSet.getInt(1),
                        miResultSet.getString(2),
                        miResultSet.getString(3),
                        miResultSet.getString(4),
                        miResultSet.getString(5),
                        miResultSet.getString(6),
                        miResultSet.getFloat(7));

                miLista.add(new Person());


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return miLista;
    }

    public void cierraConeccion() {
        try {
            miConexion.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //insert
    public boolean inserta(Person p) {
        String sql = "insert into person (id, name, lastname, email, gender, ip_address, money) values (?,?,?,?,?,?,?)";
        Statement miStatement;

        try {
            PreparedStatement sentencia = miConexion.prepareStatement(sql);
            sentencia.setInt(1, p.getId());
            sentencia.setString(2, p.getName());
            sentencia.setString(3, p.getLast_name());
            sentencia.setString(4, p.getEmail());
            sentencia.setString(5, p.getGender());
            sentencia.setString(6, p.getIp_address());
            sentencia.setFloat(7, p.getMoney());
            sentencia.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
