package Repositorios;

import Entidades.Autor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class RepoAutor implements Repositorio<Autor>{

    private Session sesion;

    public RepoAutor(Session sesion){
        this.sesion = sesion;
    }

    @Override
    public void insertarUno(Autor autor) {
        Transaction trx = sesion.beginTransaction();
        sesion.persist(autor);
        trx.commit();
    }

    @Override
    public void borrar(Autor autor) {
        Transaction trx = sesion.beginTransaction();
        sesion.remove(autor);
        trx.commit();
    }

    @Override
    public List<Autor> encontrarTodos() {
        Query query = sesion.createQuery("SELECT a FROM Autores a");
        List<Autor> autores = query.getResultList();
        return autores;
    }

    @Override
    public Autor consultarPorString(String dni) {
        Query query = sesion.createQuery("SELECT a FROM Autor a WHERE a.dniAutor = :dni");

        query.setParameter(":dni", dni);

        return (Autor) query.getSingleResult();
    }

    @Override
    public void actualizar(Autor autor) {
        Transaction trx = sesion.beginTransaction();
        sesion.merge(autor);
        trx.commit();
    }
}
