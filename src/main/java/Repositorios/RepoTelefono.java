package Repositorios;

import Entidades.Telefono;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RepoTelefono implements Repositorio<Telefono>{

    private Session sesion;

    public RepoTelefono(Session sesion){
        this.sesion = sesion;
    }

    @Override
    public void insertarUno(Telefono telefono) {
        Transaction trx = sesion.beginTransaction();
        sesion.persist(telefono);
        trx.commit();
    }

    @Override
    public void borrar(Telefono telefono) {

    }

    @Override
    public List<Telefono> encontrarTodos() {
        return List.of();
    }

    @Override
    public Telefono consultarPorString(String nombre) {
        return null;
    }

    @Override
    public void actualizar(Telefono telefono) {

    }
}
