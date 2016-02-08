/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ora.biblioapp.controller;

import java.util.List;
import ora.biblioapp.domain.PedidoBean;
import ora.biblioapp.service.PedidoService;
import ora.biblioapp.util.AppUtil;

/**
 *
 * @author Alumno
 */
public class PedidoController {
     private PedidoService pedidoService;

  public PedidoController() {
    pedidoService = new PedidoService();
  }

  public List<PedidoBean> traerClientes(PedidoBean bean) {
    return pedidoService.traerClientes(bean);
  }

  public void procesar(String accion, PedidoBean bean) {
    switch(accion){
      case AppUtil.CRUD_NUEVO:
        pedidoService.insertar(bean);
        break;
    }
  }
}
