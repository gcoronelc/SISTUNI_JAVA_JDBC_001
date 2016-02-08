
package uni.sistemas.service;

/**
 *
 * @author Alumno
 */
public interface ITransaccion <T> {
   //definir las firmas
    int RegistrarTransaccion(T t) throws Exception;
}
