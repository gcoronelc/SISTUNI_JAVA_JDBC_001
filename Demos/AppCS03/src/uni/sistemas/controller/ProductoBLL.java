package uni.sistemas.controller;

import java.util.List;
import uni.sistemas.entity.ProductoTO;
import uni.sistemas.model.ProductoDAO;

public class ProductoBLL {

    // variable

    ProductoDAO dao;
    //constructor

    public ProductoBLL() {
        dao = new ProductoDAO();
    }

    // metodos de negocio

    public List<ProductoTO> ProductoListar() throws Exception {
        return dao.readAll();
    }

    public List<ProductoTO> ProductoPorNombre(String x) throws Exception {
        return dao.readbyName(x);
    }

    public List<ProductoTO> ProductoPorLinea(int x) throws Exception {
        return dao.readByLinea(x);
    }

    public void ProductoRegistrar(ProductoTO p) throws Exception {
        dao.create(p);
    }

    public void ProductoActualiza(ProductoTO p) throws Exception {
        dao.update(p);
    }

    public void ProductoEliminar(ProductoTO p) throws Exception {
        dao.delete(p);
    }

    public ProductoTO ProductoBuscar(Object id) throws Exception{
        return dao.find(id);
    }

}
