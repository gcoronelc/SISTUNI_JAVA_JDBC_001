/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ora.biblioapp.prueba;

import java.util.List;
import ora.biblioapp.dao.espec.LibrosDaoCrud;
import ora.biblioapp.dao.impl.LibrosDaoImpl;
import ora.biblioapp.domain.LibrosBean;

/**
 *
 * @author Alumno
 */
public class Prueba02 {
    public static void main(String[] args) {
        LibrosBean bean = new LibrosBean();
        bean.setApellidos("B");
        LibrosDaoCrud librodao = new LibrosDaoImpl();
        List<LibrosBean> lista;
        lista = librodao.taerLista(bean);
        for(LibrosBean libro: lista){
            System.out.println(libro.getCodigo()+" | "+ libro.getApellidos()+" | "+libro.getNombre()+" | "+libro.getCiudad()+" | "+libro.getObra()+" | "+libro.getIsbn()+" | ");
        }
    }
    
    
    
}
