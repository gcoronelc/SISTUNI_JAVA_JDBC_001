package pe.egcc.eurekaapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pe.egcc.eurekaapp.dao.espec.ClienteDaoCrud;
import pe.egcc.eurekaapp.db.AccesoDB;
import pe.egcc.eurekaapp.domain.ClienteBean;

/**
 * Esta clase implementa el CRUD de la tabla Cliente.
 *
 * @author Gustavo Coronel
 */
public class ClienteDaoImpl
        extends AbstractRowToBean<ClienteBean>
        implements ClienteDaoCrud {

  /**
   * Lee un cliente por código.
   *
   * @param codigo Código del cliente a leer.
   * @return Retorna el bean con los datos del cliente, si no lo encuentra, retorna null.
   */
  @Override
  public ClienteBean traerPorCodigo(String codigo) {
    ClienteBean bean = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select chr_cliecodigo, vch_cliepaterno, "
              + "vch_cliematerno, vch_clienombre, "
              + "chr_cliedni, vch_clieciudad, "
              + "vch_cliedireccion, vch_clietelefono, "
              + "vch_clieemail "
              + "from cliente "
              + "where chr_cliecodigo = ? ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, codigo);
      ResultSet rs = pstm.executeQuery();
      if(rs.next()){
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

  /**
   * Consulta empleados por: Codigo, paterno, materno o nombre.
   * 
   * @param bean
   * @return 
   */
  @Override
  public List<ClienteBean> taerLista(ClienteBean bean) {

    return null;
  }

  @Override
  public void insertar(ClienteBean bean) {

  }

  @Override
  public void actualizar(ClienteBean bean) {

  }

  @Override
  public void eliminar(String codigo) {

  }

  /**
   * La fila actual de un ResultSet lo convierte en un bean.
   *
   * @param rs Objeto ResultSet con los datos.
   * @return Retorna la fila actual del ResultSet como bean.
   * @throws SQLException En caso de algun error, se genera una excepción de tipo SQLException.
   */
  @Override
  protected ClienteBean rowToBean(ResultSet rs) throws SQLException {
    ClienteBean bean = new ClienteBean();
    bean.setCodigo(rs.getString("chr_cliecodigo"));
    bean.setPaterno(rs.getString("vch_cliepaterno"));
    bean.setMaterno(rs.getString("vch_cliematerno"));
    bean.setNombre(rs.getString("vch_clienombre"));
    bean.setDni(rs.getString("chr_cliedni"));
    bean.setCiudad(rs.getString("vch_clieciudad"));
    bean.setDireccion(rs.getString("vch_cliedireccion"));
    bean.setTelefono(rs.getString("vch_clietelefono"));
    bean.setEmail(rs.getString("vch_clieemail"));
    return bean;
  }

}
