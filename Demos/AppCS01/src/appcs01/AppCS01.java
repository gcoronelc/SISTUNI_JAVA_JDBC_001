package appcs01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AppCS01 {

    public static void main(String[] args) {
        // prueba de conexion a base de datos
        Connection cn = null;
        try {
            //1.- cargar driver en memoria
            Class.forName("oracle.jdbc.OracleDriver");
            //2.- url de lam vase de datos
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            //3.- obtener conexion a base de datos
            cn = DriverManager.getConnection(url, "hr", "hr");
            System.out.println("Conexion Conforme...");
            //insertar departamento
            String sql = "insert into departments(department_id,department_name,manager_id,location_id)"
                    + " values(280,'Sistemas UNI',100,2400)";
            Statement st = cn.createStatement();
//            st.executeUpdate(sql);
//            System.out.println("Departamento registrado...");
            // lista de departamentos
            sql = "select * from departments";
            //preparar comando
            st = cn.createStatement();
            // ejecutar comando
            ResultSet rs = st.executeQuery(sql);
            // mostrar datos
            System.out.println("Lista departamentos");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "   " + rs.getString(2) + "   " + rs.getInt(4));
            }
            // departementos por region
            sql = "select * from departments where location_id=?";
            //preparar comando
            PreparedStatement ps = cn.prepareStatement(sql);
            // preparar valor del parametro
            ps.setInt(1, 1500);
            // ejecutar comando
            rs = ps.executeQuery();
            // mostrar datos
            System.out.println("Lista departamentos");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "   " + rs.getString(2) + "   " + rs.getInt(4));
            }
            rs.close();
            st.close();
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
