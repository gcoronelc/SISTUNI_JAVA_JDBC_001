
package ora.biblioapp.controller;

import ora.biblioapp.domain.SolicitanteBean;
import ora.biblioapp.service.LogonService;
import ora.biblioapp.util.Memoria;

/**
 *
 * @author GustavoCoronel
 */
public class LogonController {

  public void validar(String usuario, String clave) {
    LogonService logonService;
    logonService = new LogonService();
    SolicitanteBean bean = logonService.validar(usuario, clave);
    Memoria.put("usuario", bean);
  }
  
}
