/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.masterapp.controller;

import java.util.List;
import pe.egcc.masterapp.domain.EmpleadoBean;
import pe.egcc.masterapp.service.EmpleadoService;
import pe.egcc.masterapp.util.MasterUtil;

/**
 *
 * @author USER
 */
public class EmpleadoController {

    private EmpleadoService empleadoService;

    public EmpleadoController() {
        empleadoService = new EmpleadoService();
    }

    public List<EmpleadoBean> traerEmpleados(EmpleadoBean bean) {
        return empleadoService.traerEmpleados(bean);

    }

    public void procesar(String accion, EmpleadoBean bean) {
        switch (accion) {
            case MasterUtil.CRUD_NUEVO:
                empleadoService.insertar(bean);
                break;
        }
    }

}
