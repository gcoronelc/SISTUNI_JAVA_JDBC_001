
package ora.biblioapp.service;

import ora.biblioapp.dao.espec.SolicitanteDaoCrud;
import ora.biblioapp.dao.impl.SolicitanteDaoImpl;
import ora.biblioapp.domain.SolicitanteBean;

/**
 *
 * @author GustavoCoronel
 */
public class LogonService {
  
  public SolicitanteBean validar(String usuario, String clave){
    if(usuario == null || usuario.isEmpty()){
      throw new RuntimeException("Error, faltan datos.");
    }
    if(clave == null || clave.isEmpty()){
      throw new RuntimeException("Error, faltan datos.");
    }
    SolicitanteDaoCrud solicitanteDao;
    solicitanteDao = new SolicitanteDaoImpl();
    SolicitanteBean bean = solicitanteDao.validar(usuario, clave);
    if(bean == null){
      throw new RuntimeException("Error, datos incorrectos.");
    }
    return bean;
  }
  
}
