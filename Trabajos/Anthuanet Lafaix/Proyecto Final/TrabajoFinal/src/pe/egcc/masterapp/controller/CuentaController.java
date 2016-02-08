package pe.egcc.masterapp.controller;

import pe.egcc.masterapp.domain.EmpleadoBean;
import pe.egcc.masterapp.service.CuentaService;
import pe.egcc.masterapp.util.Memoria;

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
