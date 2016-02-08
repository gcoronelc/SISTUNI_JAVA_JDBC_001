package ora.biblioapp.dao.espec;

import ora.biblioapp.domain.SolicitanteBean;


/**
 * Definición del CRUD para la tabla EMPLEADO.
 *
 * @author Gustavo Coronel
 */
public interface SolicitanteDaoCrud extends AbstractCrud<SolicitanteBean> {

  /**
   * Se trata de un método adicional a los definidos en el CRUD. 
   * Valida un usuario en la base de datos. Usuario y Clave.
   *
   * @param usuario Cuenta de usuario.
   * @param clave Clave del usuario.
   * @return Si los parámetros son correctos retorna el bean el empleado, 
   *         caso contrario retorna null.
   */
 SolicitanteBean validar(String usuario, String clave);

}
