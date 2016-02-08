package pe.egcc.masterapp.prueba;

import pe.egcc.masterapp.dao.espec.ClienteDaoCrud;
import pe.egcc.masterapp.dao.impl.ClienteDaoImpl;
import pe.egcc.masterapp.domain.ClienteBean;

/**
 *
 * @author Gustavo Coronel
 */
public class Prueba01 {
  
  public static void main(String[] args) {
    ClienteDaoCrud clienteDao;
    clienteDao = new ClienteDaoImpl();
    
    ClienteBean bean = clienteDao.traerPorCodigo("000011");
    
    if(bean == null){
      System.err.println("No existe");
    } else {
      System.out.println("Hola " + bean.getNombre());
    }
  }
}
