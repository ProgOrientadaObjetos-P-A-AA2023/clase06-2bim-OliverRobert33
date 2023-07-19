/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete03;

import java.sql.SQLException;
import paquete01.Enlace;
import paquete02.Auto;

/**
 *
 * @author reroes
 */
public class Principal {

    public static void main(String[] args) throws SQLException {
        Enlace c = new Enlace();
        Auto a = new Auto();
        String[][] autos = {
            {"LBC0001", "230.2"},
            {"LBC0002", "330.2"},
            {"LBC0003", "430.2"},
            {"LBC0004", "530.1"},
            {"LBC0005", "130.2"}};

        // 1. guardar en la tabla autos de la base de datos
        // 2. presentar todos los registros de la tabla autos de la base de 
        // datos
//        a.establecerPlaca(autos[1][2]);
//        a.establecerValorMatricula(200.2);
        for (int i = 0; i < autos.length; i++) {
            a.establecerPlaca(autos[i][0]);
            a.establecerValorMatricula(Double.parseDouble(autos[i][1]));
            c.insertarAuto(a);
        }

        for (int i = 0; i < c.obtenerDataAuto().size(); i++) {
            System.out.printf("%s\n",
                    c.obtenerDataAuto().get(i));
//                    c.obtenerDataAuto().get(i).obtenerValorMatricula());
        }

    }
}
