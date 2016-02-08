package uni.sistemas.controller;

import uni.sistemas.entity.VentaTO;
import uni.sistemas.model.VentaDAO;

public class VentaBLL {

    VentaDAO dao;

    public VentaBLL() {
        dao = new VentaDAO();
    }

    public int RegistrarVenta(VentaTO v) throws Exception {
        return dao.RegistrarTransaccion(v);
    }

}
