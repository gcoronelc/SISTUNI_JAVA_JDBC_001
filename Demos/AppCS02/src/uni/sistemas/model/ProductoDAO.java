package uni.sistemas.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import uni.sistemas.database.AccesoDB;
import uni.sistemas.entity.ProductoTO;
import uni.sistemas.service.ICrud;

public class ProductoDAO implements ICrud<ProductoTO> {

    // variables
    Connection cn = null;
    Statement st = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    ProductoTO pr = null;
    

    // metodos de persistencia
    
    @Override
    public void create(ProductoTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(ProductoTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(ProductoTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProductoTO> readAll() throws Exception {
        List<ProductoTO> lista = new ArrayList<>();
        try {
            //obtener la conexion a la bd
            cn = AccesoDB.getConnection();
            sql = "select * from productos order by idproducto";
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                pr = new ProductoTO(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getInt(6));
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
    public ProductoTO find(Object t) throws Exception {
     
        return null;
    }
    
    public List<ProductoTO> readbyName(String nom) throws Exception {
        List<ProductoTO> lista = new ArrayList<>();
        try {
            //obtener la conexion a la bd
            cn = AccesoDB.getConnection();
            sql = "select * from productos where descripcion like ?";
            ps = cn.prepareStatement(sql);
            // prepar valor a pasar al comado
            ps.setString(1, nom+'%');
            rs = ps.executeQuery();
            while (rs.next()) {
                pr = new ProductoTO(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getInt(6));
                lista.add(pr);
            }
            rs.close();
            ps.close();
            cn.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        }
        return lista;
    }
    
    public List<ProductoTO> readByLinea(int id) throws Exception {
        List<ProductoTO> lista = new ArrayList<>();
        try {
            //obtener la conexion a la bd
            cn = AccesoDB.getConnection();
            sql = "select * from productos where idlinea=?";
            ps = cn.prepareStatement(sql);
            // prepar valor a pasar al comado
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                pr = new ProductoTO(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getInt(6));
                lista.add(pr);
            }
            rs.close();
            ps.close();
            cn.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        }
        return lista;
    }
    

}
