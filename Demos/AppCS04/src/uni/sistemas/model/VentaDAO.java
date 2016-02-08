package uni.sistemas.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import uni.sistemas.database.AccesoDB;
import uni.sistemas.entity.DetalleTO;
import uni.sistemas.entity.VentaTO;
import uni.sistemas.service.ITransaccion;

public class VentaDAO implements ITransaccion<VentaTO> {

    // variables
    Connection cn = null;
    Statement st = null;
    PreparedStatement ps, psa, psb;
    ResultSet rs = null;
    String sql = null;
    int ok;

    @Override
    public int RegistrarTransaccion(VentaTO t) throws Exception {
        int iventa;
        try {
            cn = AccesoDB.getConnection();
            // inicia transaccion
            cn.setAutoCommit(false);
            iventa = numeroVenta();//genera nro, de venta          
            // registra ventas
            sql = "Insert Into Ventas(idventa,idcliente,idempleado,tipodoc,nrodoc,fecha,total)"
                    + " Values(?,?,?,?,?,sysdate,?)";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, iventa);
            ps.setString(2, t.getIdcliente());
            ps.setString(3, t.getIdempleado());
            ps.setString(4, t.getTipodoc());
            ps.setString(5, t.getNrodoc());
            ps.setDouble(6, t.getTotal());
            ps.executeUpdate();// graba la factura
            //graba detalle venta
            sql = "Insert Into DetalleVenta(idventa,idproducto,precio,cantidad,importe)"
                    + " Values(?,?,?,?,?)";
            psa = cn.prepareStatement(sql);
            //actualiza stock
            sql = "Update Productos  set Stock = Stock - ? where idProducto=?";
            psb = cn.prepareStatement(sql);
            for (DetalleTO item : t.getDetalle()) {
                psa.setInt(1, iventa);
                psa.setString(2, item.getIdproducto());
                psa.setDouble(3, item.getPrecio());
                psa.setInt(4, item.getCantidad());
                psa.setDouble(5, item.getTotal());
                psa.executeUpdate();// graba detalleventa
                // actualizar stock de producto
                psb.setInt(1, item.getCantidad());
                psb.setString(2, item.getIdproducto());
                psb.executeUpdate();// actualiza cantidad de producto
            }
            //st.close();
            ps.close();
            psa.close();
            psb.close();
            cn.commit(); // confirma la transaccion
        } catch (SQLException | ClassNotFoundException e) {
            try {
                cn.rollback();// deshacer la transaccion
            } catch (Exception e1) {
            }
            throw e;
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return iventa;
    }

    private int numeroVenta() throws SQLException {
        sql = "Select Valor from Control where parametro='Ventas'";
        st = cn.createStatement();
        rs = st.executeQuery(sql);
        rs.next();
        int nroVenta = rs.getInt(1);
        rs.close();
        sql = "update Control set Valor=Valor+1 where parametro='Ventas'";
        st = cn.createStatement();
        st.executeUpdate(sql);
        st.close();
        return nroVenta;
    }

}
