package pe.egcc.masterapp.prueba;

import java.util.List;
import pe.egcc.masterapp.dao.espec.ClienteDaoCrud;
import pe.egcc.masterapp.dao.impl.ClienteDaoImpl;
import pe.egcc.masterapp.domain.ClienteBean;

/**
 *
 * @author Gustavo Coronel
 */
public class Prueba02 {

  public static void main(String[] args) {
    
    ClienteBean bean = new ClienteBean();
    bean.setPaterno("R");
    // bean.setMaterno("O");
    //bean.setCodigo("00004");
    
    ClienteDaoCrud clienteDao = new ClienteDaoImpl();
    List<ClienteBean> lista;
    lista = clienteDao.taerLista(bean);
    
    for (ClienteBean cliente : lista) {
      System.out.println(cliente.getCodigo() + " | "
      + cliente.getPaterno() + " | " 
      + cliente.getMaterno() + " | " 
      + cliente.getNombre());
    }
    
  }
  
}
