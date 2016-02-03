package pe.egcc.eurekaapp.dao.espec;

import pe.egcc.eurekaapp.domain.EmpleadoBean;

/**
 *
 * @author Gustavo Coronel
 */
public interface EmpleadoDaoCrud extends AbstractCrud<EmpleadoBean>{
  
  EmpleadoBean validar(String usuario, String clave);
  
}
