package uni.sistemas.service;

import java.util.List;

public interface ICrud<T> {

    // definir las firmas de los metodos

    void create(T t) throws Exception;

    void update(T t) throws Exception;

    void delete(T t) throws Exception;

    List<T> readAll() throws Exception;

    T find(Object t) throws Exception;

}
