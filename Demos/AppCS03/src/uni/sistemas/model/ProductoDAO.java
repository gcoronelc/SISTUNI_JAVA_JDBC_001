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
        try {
            cn = AccesoDB.getConnection();
            //genera codigo de poducto
            String cod = generaCodigo();
            t.setIdproducto(cod);
            sql = "insert into productos(idproducto,descripcion,idlinea,preciocompra,precioventa,stock)"
                    + " values(?,?,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, t.getIdproducto());
            ps.setString(2, t.getNombre());
            ps.setInt(3, t.getIdlinea());
            ps.setDouble(4, t.getPreciocompra());
            ps.setDouble(5, t.getPrecioventa());
            ps.setInt(6, t.getStock());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        } finally {
            cn.close();
        }
    }

    @Override
    public void update(ProductoTO t) throws Exception {
        try {
            cn = AccesoDB.getConnection();
            sql = "update productos set descripcion=?,idlinea=?,preciocompra=?,precioventa=?,stock=?"
                    + " where idproducto=?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, t.getNombre());
            ps.setInt(2, t.getIdlinea());
            ps.setDouble(3, t.getPreciocompra());
            ps.setDouble(4, t.getPrecioventa());
            ps.setInt(5, t.getStock());
            ps.setString(6, t.getIdproducto());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        } finally {
            cn.close();
        }
    }

    @Override
    public void delete(ProductoTO t) throws Exception {
        try {
            cn = AccesoDB.getConnection();
            sql = "delete from productos where idproducto=?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, t.getIdproducto());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        } finally {
            cn.close();
        }
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
        pr = null;
        try {
            //obtener la conexion a la bd
            cn = AccesoDB.getConnection();
            sql = "select * from productos where idproducto=?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, (String) t);
            rs = ps.executeQuery();
            if (rs.next()) {
                pr = new ProductoTO(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getInt(6));
            }
            rs.close();
            ps.close();
            cn.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        }
        return pr;
    }

    public List<ProductoTO> readbyName(String nom) throws Exception {
        List<ProductoTO> lista = new ArrayList<>();
        try {
            //obtener la conexion a la bd
            cn = AccesoDB.getConnection();
            sql = "select * from productos where descripcion like ?";
            ps = cn.prepareStatement(sql);
            // prepar valor a pasar al comado
            ps.setString(1, nom + '%');
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

    private String generaCodigo() throws SQLException {
        sql = "select valor from control where parametro='Productos'";
        st = cn.createStatement();
        rs = st.executeQuery(sql);
        rs.next();
        int cont = rs.getInt(1);//
        rs.close();
        sql = "update control set valor=valor+1 where parametro='Productos'";
        st = cn.createStatement();
        st.executeUpdate(sql);
        st.close();
        String codigo = "";
        if (cont < 10) {
            codigo = "A000" + cont;
        } else {
            codigo = "A00" + cont;
        }
        return codigo;
    }

}
