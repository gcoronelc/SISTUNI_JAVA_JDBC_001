package uni.sistemas.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import uni.sistemas.database.AccesoDB;
import uni.sistemas.entity.EmpleadoTO;
import uni.sistemas.service.ICrud;

public class EmpleadoDAO implements ICrud<EmpleadoTO> {

    // variables
    Connection cn = null;
    PreparedStatement ps = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    String sql;

    // constantes
    final String SQL_INSERT = "{call sp_Empleado_Adicionar(?,?,?,?,?,?)}";
    final String SQL_UPDATE = "{call sp_Empleado_Actualizar(?,?,?,?,?,?)}";
    final String SQL_DELETE = "{call sp_Empleado_Eliminar(?)}";
    final String SQL_SELECT = "select * from empleados";

    // metodos para la persistencia de datos
    @Override
    public void create(EmpleadoTO t) throws Exception {
        try {
            cn = AccesoDB.getConnection();
            String codigo = generaCodigo();
            t.setIdempleado(codigo);
            cs = cn.prepareCall(SQL_INSERT);
            cs.setString(1, t.getIdempleado());
            cs.setString(2, t.getNombre());
            cs.setString(3, t.getApellido());
            cs.setString(4, t.getEmail());
            cs.setString(5, t.getUsuario());
            cs.setString(6, t.getPassword());
            cs.executeUpdate();
            cs.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        } finally {
            cn.close();
        }
    }

    @Override
    public void update(EmpleadoTO t) throws Exception {
        try {
            cn = AccesoDB.getConnection();
            cs = cn.prepareCall(SQL_UPDATE);
            cs.setString(1, t.getIdempleado());
            cs.setString(2, t.getNombre());
            cs.setString(3, t.getApellido());
            cs.setString(4, t.getEmail());
            cs.setString(5, t.getUsuario());
            cs.setString(6, t.getPassword());
            cs.executeUpdate();
            cs.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        } finally {
            cn.close();
        }
    }

    @Override
    public void delete(EmpleadoTO t) throws Exception {
        try {
            cn = AccesoDB.getConnection();
            cs = cn.prepareCall(SQL_DELETE);
            cs.setString(1, t.getIdempleado());
            cs.executeUpdate();
            cs.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        } finally {
            cn.close();
        }
    }

    @Override
    public List<EmpleadoTO> readAll() throws Exception {
        List<EmpleadoTO> lista = new ArrayList<>();
        try {
            cn = AccesoDB.getConnection();
            ps = cn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            while (rs.next()) {
                EmpleadoTO emp = new EmpleadoTO();
                emp.setIdempleado(rs.getString(1));
                emp.setNombre(rs.getString(2));
                emp.setApellido(rs.getString(3));
                emp.setEmail(rs.getString(4));
                lista.add(emp);
            }
            rs.close();
            ps.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        } finally {
            cn.close();
        }
        return lista;
    }

    @Override
    public EmpleadoTO find(Object t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String generaCodigo() throws SQLException {
        Statement st;
        sql = "select valor from control where parametro='Empleados'";
        st = cn.createStatement();
        rs = st.executeQuery(sql);
        rs.next();
        int cont = rs.getInt(1);//
        rs.close();
        sql = "update control set valor=valor+1 where parametro='Empleados'";
        st = cn.createStatement();
        st.executeUpdate(sql);
        st.close();
        String codigo = "";
        if (cont < 10) {
            codigo = "E000" + cont;
        } else {
            codigo = "E00" + cont;
        }
        return codigo;
    }

    public String validar(String usu, String pass) throws SQLException, ClassNotFoundException {
        String xusu=null;
        try {
            cn = AccesoDB.getConnection();
            sql="select * from empleados where usuario=? and clave=?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, usu);
            ps.setString(2,pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                xusu=rs.getString(2)+" "+rs.getString(3);                
            }
            rs.close();
            ps.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        } finally {
            cn.close();
        }
        return xusu;
    }

}
