package pe.egcc.masterapp.prueba;

import java.util.List;
import pe.egcc.masterapp.dao.espec.ClienteDaoCrud;
import pe.egcc.masterapp.dao.impl.ClienteDaoImpl;
import pe.egcc.masterapp.domain.ClienteBean;

/**
 *
 * @author GustavoCoronel
 */
public class Prueba04 {

  public static void main(String[] args) {
    ClienteBean bean = new ClienteBean();
    bean.setPaterno("A");
    bean.setMaterno("B");
    bean.setNombre("C");
    bean.setDni("E");
    bean.setCiudad("F");
    bean.setDireccion("F");
    bean.setTelefono("1");
    bean.setEmail("G");

    ClienteDaoCrud clienteDao = new ClienteDaoImpl();
    clienteDao.insertar(bean);
    
    System.out.println("Todo ok. Codigo: " + bean.getCodigo());
  }

}
