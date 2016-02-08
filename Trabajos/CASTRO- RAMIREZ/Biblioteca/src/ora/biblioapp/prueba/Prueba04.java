/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ora.biblioapp.prueba;

import java.util.List;
import ora.biblioapp.dao.espec.PedidoDaoCrud;
import ora.biblioapp.dao.impl.PedidoDaoImpl;
import ora.biblioapp.domain.PedidoBean;

/**
 *
 * @author Alumno
 */
public class Prueba04 {
    public static void main(String[] args) {
        PedidoBean bean = new PedidoBean();
        bean.setNombre("E");
        PedidoDaoCrud pedidoDao = new PedidoDaoImpl();
        List<PedidoBean> lista;
        lista = pedidoDao.taerLista(bean);
        for(PedidoBean pedido: lista){
            System.out.println(pedido.getCodigo()+" | "+ pedido.getNombre()+" | "+pedido.getFecha());
        }
    
}}
