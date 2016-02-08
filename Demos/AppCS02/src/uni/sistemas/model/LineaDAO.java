package uni.sistemas.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import uni.sistemas.database.AccesoDB;
import uni.sistemas.entity.LineaTO;
import uni.sistemas.entity.ProductoTO;
import uni.sistemas.service.ICrud;

public class LineaDAO implements ICrud<LineaTO> {

    // variables

    Connection cn = null;
    Statement st = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    LineaTO linea = null;

    @Override
    public void create(LineaTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(LineaTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(LineaTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LineaTO> readAll() throws Exception {
        List<LineaTO> lista = new ArrayList<>();
        try {
            //obtener la conexion a la bd
            cn = AccesoDB.getConnection();
            sql = "select * from lineas order by idlinea";
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                linea = new LineaTO(rs.getInt(1),
                        rs.getString(2));
                lista.add(linea);
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
    public LineaTO find(Object t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
