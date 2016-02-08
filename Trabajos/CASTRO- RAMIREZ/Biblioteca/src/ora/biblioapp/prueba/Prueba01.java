/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ora.biblioapp.prueba;

import ora.biblioapp.dao.espec.LibrosDaoCrud;
import ora.biblioapp.dao.impl.LibrosDaoImpl;
import ora.biblioapp.domain.LibrosBean;

/**
 *
 * @author Alumno
 */
public class Prueba01 {
    public static void main(String[] args) {
        LibrosDaoCrud librosDao;
        librosDao = new LibrosDaoImpl();
        LibrosBean bean = librosDao.traerPorCodigo("0011");
        if(bean ==null){
            System.err.println("No existe");
        }else{
            System.err.println("hola"+bean.getNombre());
        }
            
    }
    
    
}
