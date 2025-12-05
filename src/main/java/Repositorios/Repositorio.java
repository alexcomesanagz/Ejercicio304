package Repositorios;

import java.util.List;

public interface Repositorio<T> {

    void insertarUno(T t);
    void borrar(T t);
    List<T> encontrarTodos();
    void  consultarPorString(String nombre);
    void actualizar(T t);

}
