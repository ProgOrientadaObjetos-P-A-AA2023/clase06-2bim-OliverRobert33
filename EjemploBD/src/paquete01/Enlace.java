package paquete01;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

import paquete02.Ciudad;

public class Enlace {

    private Connection conn;
    private ArrayList<Ciudad> dataC;

    public ArrayList<Ciudad> obtenerDataC() {
        return dataC;
    }

    public void establecerConexion() {

        try {
            String url = "jdbc:sqlite:bd/base01.bd";
            conn = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Connection obtenerConexion() {
        return conn;
    }

    public void insertarCiudad(Ciudad ciudad) {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO Ciudad (nombre, poblacion) "
                    + "values ('%s', %d)", ciudad.obtenerNombre(),
                    ciudad.obtenerPoblacion());
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarCiudad");
            System.out.println(e.getMessage());

        }
    }

    public void establecerDataCiudad() {
        dataC = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from Ciudad;";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                Ciudad miCiudad = new Ciudad(rs.getString("nombre"),
                        rs.getInt("poblacion"));
                dataC.add(miCiudad);
            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarCiudad");
            System.out.println(e.getMessage());

        }

    }

}
