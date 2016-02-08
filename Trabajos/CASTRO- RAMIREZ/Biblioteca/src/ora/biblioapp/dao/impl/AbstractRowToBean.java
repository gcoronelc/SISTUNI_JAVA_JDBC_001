package ora.biblioapp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gustavo Coronel
 */
public abstract class AbstractRowToBean<T> {
  
  protected abstract T rowToBean(ResultSet rs)
          throws SQLException;
  
}
