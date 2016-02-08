/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.sistemas.prueba;

import java.sql.Connection;
import java.sql.SQLException;
import uni.sistemas.database.AccesoDB;

/**
 *
 * @author Alumno
 */
public class prueba {

    public static void main(String[] args) {
        try {
            Connection cn = AccesoDB.getConnection();
            System.out.println("Conexion conforme....");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
