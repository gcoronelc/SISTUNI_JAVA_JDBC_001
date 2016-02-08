package ora.biblioapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ora.biblioapp.dao.db.AccesoDB;
import ora.biblioapp.dao.espec.LibrosDaoCrud;
import ora.biblioapp.domain.LibrosBean;
import ora.biblioapp.util.AppUtil;

/**
 * Esta clase implementa el CRUD de la tabla Cliente.
 *
 * @author Gustavo Coronel
 */
public class LibrosDaoImpl
        extends AbstractRowToBean<LibrosBean>
        implements LibrosDaoCrud {

    /**
     * Lee un cliente por código.
     *
     * @param codigo Código del cliente a leer.
     * @return Retorna el bean con los datos del cliente, si no lo encuentra,
     * retorna null.
     */
    @Override
    public LibrosBean traerPorCodigo(String codigo) {
        LibrosBean bean = null;
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "select chr_libbcodigo, vch_libbapellidos, "
                    + "vch_libbnombre, vch_libbciudad, "
                    + "vch_libbobra, vch_libbisbn "
                    + "from libros "
                    + "where chr_libbcodigo = ? ";
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

    /**
     * Consulta de empleados por: Codigo, paterno, materno o nombre.
     *
     * @param bean Este bean trae los datos por los que se realizará la
     * consulta.
     * @return Retorna una lista de tipo ClienteBean con los datos encontrados.
     */
    @Override
    public List<LibrosBean> taerLista(LibrosBean bean) {
        List<LibrosBean> lista = new ArrayList<>();
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "select chr_libbcodigo, vch_libbapellidos, "
                    + "vch_libbnombre, vch_libbciudad, "
                    + "vch_libbobra, vch_libbisbn "
                    + "from libros "
                    + "where (chr_libbcodigo like ? ) "
                    + "and (vch_libbapellidos like ?  "
                    + "and vch_libbnombre like ?  "
                    + "and vch_libbobra like ?  "
                    + "and vch_libbisbn like ? ) ";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, AppUtil.aString(bean.getCodigo()) + "%");
            pstm.setString(2, AppUtil.aString(bean.getApellidos()) + "%");
            pstm.setString(3, AppUtil.aString(bean.getNombre()) + "%");
            pstm.setString(4, AppUtil.aString(bean.getObra()) + "%");
            pstm.setString(5, AppUtil.aString(bean.getIsbn()) + "%");

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                LibrosBean beanCliente = rowToBean(rs);
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

    /**
     * Inserta un negistro en la tabla Cliente.
     *
     * @param bean Este bean trae los datos del cliente a insertar.
     */
    @Override
    public void insertar(LibrosBean bean) {
        Connection cn = null;
        try {
            // Obtener la conexión
            cn = AccesoDB.getConnection();
            // Habilitar la transacción
            cn.setAutoCommit(false);
            // Paso 1: Leer datos del contador
            String sql = "select int_contitem, int_contlongitud "
                    + "from contador "
                    + "where vch_conttabla = 'libros' "
                    + "for update ";
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            if (!rs.next()) {
                throw new SQLException("ERROR: El contador de clientes no existe.");
            }
            int cont = rs.getInt("int_contitem");
            int size = rs.getInt("int_contlongitud");
            rs.close();
            pstm.close();
            // Actualizar contador
            cont++;
            sql = "update contador set int_contitem = ? "
                    + "where vch_conttabla = 'libros'";
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, cont);
            pstm.executeUpdate();
            // Generar Código
            String patron = "%0" + size + "d";
            String codigo = String.format(patron, cont);
            // Registrar al cliente
            sql = " insert into libros(chr_libbcodigo ,vch_libbapellidos,"
                    + "vch_libbnombre,vch_libbciudad,"
                    + "vch_libbobra   , vch_libbisbn) "
                    + "values(?,?,?,?,?,?) ";

            pstm = cn.prepareStatement(sql);
            pstm.setString(1, codigo);
            pstm.setString(2, bean.getApellidos());
            pstm.setString(3, bean.getNombre());
            pstm.setString(4, bean.getCiudad());
            pstm.setString(5, bean.getObra());
            pstm.setString(6, bean.getIsbn());

            pstm.executeUpdate();
            pstm.close();
            bean.setCodigo(codigo);
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

    @Override
    public void actualizar(LibrosBean bean) {

    }

    @Override
    public void eliminar(String codigo) {

    }

    /**
     * La fila actual de un ResultSet lo convierte en un bean.
     *
     * @param rs Objeto ResultSet con los datos.
     * @return Retorna la fila actual del ResultSet como bean.
     * @throws SQLException En caso de algun error, se genera una excepción de
     * tipo SQLException.
     */
    @Override
    protected LibrosBean rowToBean(ResultSet rs) throws SQLException {
        LibrosBean bean = new LibrosBean();
        bean.setCodigo(rs.getString("chr_libbcodigo"));
        bean.setApellidos(rs.getString("vch_libbapellidos"));
        bean.setNombre(rs.getString("vch_libbnombre"));
        bean.setCiudad(rs.getString("vch_libbciudad"));
        bean.setObra(rs.getString("vch_libbobra"));
        bean.setIsbn(rs.getString("vch_libbisbn"));

        return bean;
    }

}
