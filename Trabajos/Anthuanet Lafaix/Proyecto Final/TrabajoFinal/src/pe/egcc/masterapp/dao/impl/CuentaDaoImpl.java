package pe.egcc.masterapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.egcc.masterapp.dao.espec.CuentaDaoEspec;
import pe.egcc.masterapp.db.AccesoDB;

/**
 *
 * @author GustavoCoronel
 */
public class CuentaDaoImpl implements CuentaDaoEspec {

  @Override
  public void registrarDeposito(String cuenta, double importe, String codEmp) {
    Connection cn = null;
    try {
      // Obtener la conexión
      cn = AccesoDB.getConnection();
      // Habilitar la transacción
      cn.setAutoCommit(false);
      // Paso 1: Leer datos de la cuenta
      String sql = "select dec_cuensaldo, int_cuencontmov "
              + "from cuenta "
              + "where chr_cuencodigo = ? "
              + "for update ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      ResultSet rs = pstm.executeQuery();
      if (!rs.next()) {
        throw new SQLException("Error, cuenta no existe.");
      }
      double saldo = rs.getDouble("dec_cuensaldo");
      int cont = rs.getInt("int_cuencontmov");
      rs.close();
      pstm.close();
      // Paso 2: Actualizar la cuenta
      saldo += importe;
      cont++;
      sql = "update cuenta "
              + "set dec_cuensaldo = ?, "
              + "int_cuencontmov = ? "
              + "where chr_cuencodigo = ? ";
      pstm = cn.prepareStatement(sql);
      pstm.setDouble(1, saldo);
      pstm.setInt(2, cont);
      pstm.setString(3, cuenta);
      pstm.executeUpdate();
      pstm.close();
      // Paso 3: Registrar movimiento
      sql = "insert into movimiento(chr_cuencodigo,"
              + "int_movinumero,dtt_movifecha,chr_emplcodigo,chr_tipocodigo,"
              + "dec_moviimporte) values(?,?,SYSDATE,?,'003',?)";
      pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      pstm.setInt(2, cont);
      pstm.setString(3, codEmp);
      pstm.setDouble(4, importe);
      pstm.executeUpdate();
      // Confimar transacción
      cn.commit();
    } catch (SQLException e) {
      try {
        cn.rollback();
      } catch (Exception e1) {
      }
      throw new RuntimeException(e.getMessage());
    } catch (Exception e) {
      try {
        cn.rollback();
      } catch (Exception e1) {
      }
      throw new RuntimeException("Error en el proceso Registrar Deposito, intentelo mas tarde.");
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }

}
