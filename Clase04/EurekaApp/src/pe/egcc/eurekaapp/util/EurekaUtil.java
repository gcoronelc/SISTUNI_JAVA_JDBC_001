package pe.egcc.eurekaapp.util;

/**
 * Clase de métodos genericos.
 *
 * @author Gustavo Coronel
 */
public final class EurekaUtil {

  private EurekaUtil() {
  }

  public static String aString(String value) {
    if (value == null) {
      value = "";
    }
    return value;
  }
  
  
}
