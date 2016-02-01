package pe.egcc.prueba;

import java.sql.Connection;
import pe.egcc.db.AccesoDB;

/**
 *
 * @author GustavoCoronel
 */
public class Prueba02 {

  
  public static void main(String[] args) {
    try {
      Connection cn;
      cn = AccesoDB.getConnection();
      System.out.println("Conexión ok.");
      cn.close();
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
  
}
