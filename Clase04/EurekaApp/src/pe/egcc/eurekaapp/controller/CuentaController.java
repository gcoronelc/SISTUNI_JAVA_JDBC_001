package pe.egcc.eurekaapp.controller;

import pe.egcc.eurekaapp.domain.EmpleadoBean;
import pe.egcc.eurekaapp.service.CuentaService;
import pe.egcc.eurekaapp.util.Memoria;

/**
 *
 * @author Gustavo Coronel
 */
public class CuentaController {
  
  public void registrarDeposito(String cuenta, double importe){
    // Empleado
    EmpleadoBean bean = (EmpleadoBean) Memoria.get("usuario");
    CuentaService service = new CuentaService();
    service.registrarDeposito(cuenta, importe, bean.getCodigo());
  }
  
}
