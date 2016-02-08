
package uni.sistemas.controller;

import java.util.List;
import uni.sistemas.entity.LineaTO;
import uni.sistemas.model.LineaDAO;


public class LineaBLL {
  // variable
    LineaDAO dao;
    // constructor

    public LineaBLL() {
        dao=new LineaDAO();
    }
    // metodos de negocio
    public List<LineaTO> LineaListar() throws Exception{
       return dao.readAll();
    }
    
}
