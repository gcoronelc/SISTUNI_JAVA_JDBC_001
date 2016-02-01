package pe.egcc.prueba;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Gustavo Coronel
 */
public class Prueba01 {

  public static void main(String[] args) {

    // Parametros para la conexión con JDBC
    String driver = "oracle.jdbc.OracleDriver";
    String urlDB = "jdbc:oracle:thin:@localhost:1521:XE";
    String user = "uni";
    String pass = "uni";

    try {

      // Cargar el driver
      Class.forName(driver).newInstance();

      // Realizar la conexión
      Connection cn;
      cn = DriverManager.getConnection(urlDB, user, pass);
      
      // Mensaje
      System.out.println("Conexión corrcta.");
      
      // Cerrar la conexión
      cn.close();
      
    } catch (ClassNotFoundException e) {
      System.out.println("ERROR: No se encontro el driver.");
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
