package ora.biblioapp.dao.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gustavo Coronel
 */
public final class AccesoDB {

  private AccesoDB() {
  }

  public final static Connection getConnection() throws SQLException {
    // Objeto Connection
    Connection cn = null;
    // Parametros para la conexión con JDBC
    String driver = "oracle.jdbc.OracleDriver";
    String urlDB = "jdbc:oracle:thin:@localhost:1521:XE";
    String user = "sol";
    String pass = "admin";
    // Proceso
    try {
      // Cargar el driver
      Class.forName(driver).newInstance();
      // Realizar la conexión
      cn = DriverManager.getConnection(urlDB, user, pass);      
    } catch (ClassNotFoundException e) {
      throw new SQLException("No se ha encontrado el driver.");
    } catch (Exception e) {
      e.printStackTrace();
      throw new SQLException("No se tiene acceso al servidor.");
    }    
    // Retornar conexión
    return cn;
  }

}
