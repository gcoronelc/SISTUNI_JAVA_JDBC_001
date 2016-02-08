/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.masterapp.controller;

import java.util.List;
import pe.egcc.masterapp.domain.ClienteBean;
import pe.egcc.masterapp.service.ClienteService;
import pe.egcc.masterapp.util.MasterUtil;

/**
 *
 * @author GustavoCoronel
 */
public class ClienteController {

  private ClienteService clienteService;

  public ClienteController() {
    clienteService = new ClienteService();
  }

  public List<ClienteBean> traerClientes(ClienteBean bean) {
    return clienteService.traerClientes(bean);
  }

  public void procesar(String accion, ClienteBean bean) {
    switch(accion){
      case MasterUtil.CRUD_NUEVO:
        clienteService.insertar(bean);
        break;
    }
  }

}
