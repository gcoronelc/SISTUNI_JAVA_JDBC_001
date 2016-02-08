/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ora.biblioapp.prueba;

import ora.biblioapp.dao.espec.PedidoDaoCrud;
import ora.biblioapp.dao.impl.PedidoDaoImpl;
import ora.biblioapp.domain.PedidoBean;

/**
 *
 * @author Alumno
 */
public class Prueba03 {
    public static void main(String[] args) {
        PedidoDaoCrud pedidoDao;
        pedidoDao = new PedidoDaoImpl();
        PedidoBean bean = pedidoDao.traerPorCodigo("00100001");
        if(bean ==null){
            System.err.println("No existe");
        }else{
            System.err.println("hola "+bean.getNombre());
        }
    }
            
    
}
