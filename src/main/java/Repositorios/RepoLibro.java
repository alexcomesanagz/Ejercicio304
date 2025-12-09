package Repositorios;

import Entidades.Libro;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class RepoLibro implements Repositorio<Libro>{

    private Session sesion;

    public RepoLibro(Session sesion){
        this.sesion = sesion;
    }

    @Override
    public void insertarUno(Libro libro){
        Transaction trx = sesion.beginTransaction();
        sesion.persist(libro);
        trx.commit();
    }

    @Override
    public void borrar(Libro libro) {
        Transaction trx = sesion.beginTransaction();
        sesion.remove(libro);
        trx.commit();
    }

    @Override
    public List<Libro> encontrarTodos() {
        Query query = sesion.createQuery("SELECT l FROM Libro l");
        List<Libro> libros = query.getResultList();
        return libros;
    }

    @Override
    public Libro consultarPorString(String titulo) {
        Query query = sesion.createQuery("SELECT l FROM Libro l WHERE l.titulo = :titulo");

        query.setParameter(":titulo", titulo);

        return (Libro) query.getSingleResult();
    }

    @Override
    public void actualizar(Libro libro) {
        Transaction trx = sesion.beginTransaction();
        sesion.merge(libro);
        trx.commit();
    }

}
