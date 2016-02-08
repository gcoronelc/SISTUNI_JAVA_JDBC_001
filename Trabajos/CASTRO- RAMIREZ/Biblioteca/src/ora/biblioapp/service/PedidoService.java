/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ora.biblioapp.service;

import java.util.List;
import ora.biblioapp.dao.espec.PedidoDaoCrud;
import ora.biblioapp.dao.impl.PedidoDaoImpl;
import ora.biblioapp.domain.PedidoBean;


/**
 *
 * @author Alumno
 */
public class PedidoService {
    
      private PedidoDaoCrud pedidoDao;

  public PedidoService() {
    pedidoDao = new PedidoDaoImpl();
  }
  
  public List<PedidoBean> traerClientes(PedidoBean bean) {
    return pedidoDao.taerLista(bean);
  }

  public void insertar(PedidoBean bean) {
    pedidoDao.insertar(bean);
  }
}
