package uni.sistemas.controller;

import java.sql.SQLException;
import java.util.List;
import uni.sistemas.entity.EmpleadoTO;
import uni.sistemas.model.EmpleadoDAO;

public class EmpleadoBLL {

    // variable

    EmpleadoDAO dao;
    //constructor

    public EmpleadoBLL() {
        dao = new EmpleadoDAO();
    }

    // metodos de negocio

    public void EmpleadoRegistrar(EmpleadoTO e) throws Exception {
        dao.create(e);
    }

    public void EmpleadoActualizar(EmpleadoTO e) throws Exception {
        dao.update(e);
    }

    public void EmpleadoEliminar(EmpleadoTO e) throws Exception {
        dao.delete(e);
    }

    public List<EmpleadoTO> EmpleadoListar() throws Exception {
        return dao.readAll();
    }
    
    public String EmpleadoValidar(String u,String p) throws SQLException, ClassNotFoundException{
        return dao.validar(u, p);
    }

}
