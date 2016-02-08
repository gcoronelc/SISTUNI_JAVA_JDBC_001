/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ora.biblioapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import ora.biblioapp.dao.db.AccesoDB;
import ora.biblioapp.dao.espec.SolicitanteDaoCrud;
import ora.biblioapp.domain.SolicitanteBean;

/**
 *
 * @author Claudia
 */
public class SolicitanteDaoImpl implements SolicitanteDaoCrud{

    @Override
public SolicitanteBean validar(String usuario, String clave) {
SolicitanteBean bean = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql =  "select chr_emplcodigo, vch_emplpaterno, "
              + "vch_emplmaterno, vch_emplnombre, "
              + "vch_emplciudad, vch_empldireccion, "
              + "vch_emplusuario "
              + "from empleado "
              + "where vch_emplusuario = ? "
              + "and vch_emplclave = ? ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, usuario);
      pstm.setString(2, clave);
      ResultSet rs = pstm.executeQuery();
      if(rs.next()){
                  bean = new SolicitanteBean();

        bean.setCodigo(rs.getString("chr_emplcodigo"));
        bean.setPaterno(rs.getString("vch_emplpaterno"));
        bean.setMaterno(rs.getString("vch_emplmaterno"));
        bean.setNombre(rs.getString("vch_emplnombre"));
        bean.setCiudad(rs.getString("vch_emplciudad"));
        bean.setDireccion(rs.getString("vch_empldireccion"));
        bean.setUsuario(rs.getString("vch_emplusuario"));
      }
      rs.close();
      pstm.close();
    } catch (SQLException e) {
      throw new RuntimeException(e.getMessage());
    } catch (Exception e) {
      e.printStackTrace();
      String msg = "Error en el proceso de validación.";
      if (e.getMessage() != null) {
        msg += "\n" + e.getMessage();
      }
      throw new RuntimeException(msg);
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return bean;    }

    @Override
    public SolicitanteBean traerPorCodigo(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SolicitanteBean> taerLista(SolicitanteBean bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertar(SolicitanteBean bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(SolicitanteBean bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    
    
}
