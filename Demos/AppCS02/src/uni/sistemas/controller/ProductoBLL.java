
package uni.sistemas.controller;

import java.util.List;
import uni.sistemas.entity.ProductoTO;
import uni.sistemas.model.ProductoDAO;

public class ProductoBLL {
   // variable
    ProductoDAO dao;
    //constructor

    public ProductoBLL() {
        dao=new ProductoDAO();
    }
    // metodos de negocio
    public List<ProductoTO> ProductoListar() throws Exception{
        return dao.readAll();
    }
    
    public List<ProductoTO> ProductoPorNombre(String x) throws Exception{
        return dao.readbyName(x);
    }
    
    public List<ProductoTO> ProductoPorLinea(int x) throws Exception{
        return dao.readByLinea(x);
    }
    
}
