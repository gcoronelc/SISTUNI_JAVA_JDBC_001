
package uni.sistemas.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import uni.sistemas.database.AccesoDB;
import uni.sistemas.entity.ClienteTO;
import uni.sistemas.entity.ProductoTO;
import uni.sistemas.service.ICrud;

public class ClienteDAO implements ICrud<ClienteTO>{
    // variables
    Connection cn = null;
    Statement st = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    ClienteTO pr = null;
    
    @Override
    public void create(ClienteTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(ClienteTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(ClienteTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ClienteTO> readAll() throws Exception {
     List<ClienteTO> lista = new ArrayList<>();
        try {
            //obtener la conexion a la bd
            cn = AccesoDB.getConnection();
            sql = "select * from clientes";
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                pr = new ClienteTO(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5) );
                lista.add(pr);
            }
            rs.close();
            st.close();
            cn.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        }
        return lista;
    }

    @Override
    public ClienteTO find(Object t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
    
}
