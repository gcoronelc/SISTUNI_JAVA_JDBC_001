
package pe.egcc.masterapp.controller;

import pe.egcc.masterapp.domain.EmpleadoBean;
import pe.egcc.masterapp.service.LogonService;
import pe.egcc.masterapp.util.Memoria;

/**
 *
 * @author GustavoCoronel
 */
public class LogonController {

  public void validar(String usuario, String clave) {
    LogonService logonService;
    logonService = new LogonService();
    EmpleadoBean bean = logonService.validar(usuario, clave);
    Memoria.put("usuario", bean);
  }
  
}
