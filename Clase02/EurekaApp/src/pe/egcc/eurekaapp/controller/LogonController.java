
package pe.egcc.eurekaapp.controller;

/**
 *
 * @author GustavoCoronel
 */
public class LogonController {

  public void validar(String usuario, String clave) {
    if(!usuario.equals("gustavo")){
      throw new RuntimeException("Datos incorrectos.");
    }
  }
  
}
