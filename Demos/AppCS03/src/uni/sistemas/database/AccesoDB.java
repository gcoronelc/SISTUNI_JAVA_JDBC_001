package uni.sistemas.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoDB {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection cn;
        try {
            //cargar el driver en memoria
            Class.forName("oracle.jdbc.OracleDriver");
            // obtener objto conecion
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            cn = DriverManager.getConnection(url, "ventas", "admin");
            return cn;
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }

    }

}
