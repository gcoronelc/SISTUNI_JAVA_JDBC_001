/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.masterapp.service;

import java.util.List;
import pe.egcc.masterapp.dao.espec.EmpleadoDaoCrud;
import pe.egcc.masterapp.dao.impl.EmpleadoDaoImpl;
import pe.egcc.masterapp.domain.EmpleadoBean;

/**
 *
 * @author USER
 */
public class EmpleadoService {
    private EmpleadoDaoCrud empleadoDao;
    
    public EmpleadoService(){
        empleadoDao = new EmpleadoDaoImpl();
        
    }
    public List<EmpleadoBean> traerEmpleados(EmpleadoBean bean){
        return empleadoDao.taerLista(bean);
    }
    public void insertar(EmpleadoBean bean){
        empleadoDao.insertar(bean);
    }
    
}
