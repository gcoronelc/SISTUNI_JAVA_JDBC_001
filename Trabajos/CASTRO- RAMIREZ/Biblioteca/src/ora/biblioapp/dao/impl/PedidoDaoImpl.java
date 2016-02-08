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
import java.util.ArrayList;
import java.util.List;
import ora.biblioapp.dao.db.AccesoDB;
import ora.biblioapp.dao.espec.PedidoDaoCrud;
import ora.biblioapp.domain.PedidoBean;
import ora.biblioapp.util.AppUtil;

/**
 *
 * @author Alumno
 */
public class PedidoDaoImpl extends AbstractRowToBean<PedidoBean>
        implements PedidoDaoCrud {

    @Override
    protected PedidoBean rowToBean(ResultSet rs) throws SQLException {
        PedidoBean bean = new PedidoBean();
        bean.setCodigo(rs.getString("chr_cuencodigo"));
        //bean.setFecha(rs.getString("vch_cliepaterno"));
        bean.setFecha(rs.getString("dtt_cuenfecha"));
        bean.setNombre(rs.getString("chr_cuennombre"));

        return bean;
    }

    @Override
    public PedidoBean traerPorCodigo(String codigo) {
        PedidoBean bean = null;
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "select chr_cuencodigo, "
                    + "chr_cuennombre, "
                    + "dtt_cuenfecha "
                    + "from pedido "
                    + "where chr_cuencodigo = ?";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                bean = rowToBean(rs);
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
        return bean;
    }

    @Override
    public List<PedidoBean> taerLista(PedidoBean bean) {
        List<PedidoBean> lista = new ArrayList<>();
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "select chr_cuencodigo, "
                    + "chr_cuennombre, "
                    + "dtt_cuenfecha "
                    + "from pedido "
                    + "where (chr_cuencodigo like ? ) "
                    + "and (chr_cuennombre like ?  "
                    + "and dtt_cuenfecha like ? )";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, AppUtil.aString(bean.getCodigo()) + "%");
            pstm.setString(2, AppUtil.aString(bean.getNombre()) + "%");
            pstm.setString(3, AppUtil.aString(bean.getFecha()) + "%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                PedidoBean beanCliente = rowToBean(rs);
                lista.add(beanCliente);
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
        return lista;
    }

    @Override
    public void insertar(PedidoBean bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(PedidoBean bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
