/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ora.biblioapp.controller;

import java.util.List;
import ora.biblioapp.domain.LibrosBean;
import ora.biblioapp.service.LibrosService;
import ora.biblioapp.util.AppUtil;


/**
 *
 * @author GustavoCoronel
 */
public class LibrosController {

  private LibrosService librosService;

  public LibrosController() {
    librosService = new LibrosService();
  }

  public List<LibrosBean> traerLibros(LibrosBean bean) {
    return librosService.traerLibros(bean);
  }

  public void procesar(String accion, LibrosBean bean) {
    switch(accion){
      case AppUtil.CRUD_NUEVO:
       librosService.insertar(bean);
        break;
    }
  }

}
