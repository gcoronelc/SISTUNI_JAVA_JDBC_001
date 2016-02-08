package pe.egcc.masterapp.service;

import java.util.List;
import pe.egcc.masterapp.dao.espec.ClienteDaoCrud;
import pe.egcc.masterapp.dao.impl.ClienteDaoImpl;
import pe.egcc.masterapp.domain.ClienteBean;

/**
 *
 * @author GustavoCoronel
 */
public class ClienteService {

  private ClienteDaoCrud clienteDao;

  public ClienteService() {
    clienteDao = new ClienteDaoImpl();
  }
  
  public List<ClienteBean> traerClientes(ClienteBean bean) {
    return clienteDao.taerLista(bean);
  }

  public void insertar(ClienteBean bean) {
    clienteDao.insertar(bean);
  }
  
}
