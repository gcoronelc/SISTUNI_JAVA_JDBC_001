package ora.biblioapp.service;

import java.util.List;
import ora.biblioapp.dao.espec.LibrosDaoCrud;
import ora.biblioapp.dao.impl.LibrosDaoImpl;
import ora.biblioapp.domain.LibrosBean;

/**
 *
 * @author GustavoCoronel
 */
public class LibrosService {

  private LibrosDaoCrud librosDao;

  public LibrosService() {
   librosDao = new LibrosDaoImpl();
  }
  
  public List<LibrosBean> traerLibros(LibrosBean bean) {
    return librosDao.taerLista(bean);
  }

  public void insertar(LibrosBean bean) {
   librosDao.insertar(bean);
  }
  
}
