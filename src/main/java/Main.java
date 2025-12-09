import Entidades.Autor;
import Entidades.Libro;
import Entidades.Telefono;
import Repositorios.RepoAutor;
import Repositorios.RepoLibro;
import Repositorios.RepoTelefono;
import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner sc;
    private static RepoAutor repoAutor;
    private static RepoLibro repoLibro;
    private static RepoTelefono repoTelefono;

    public static void main(String[] args) {
        System.out.println("Test");

        sc = new Scanner(System.in);

        Session session = HibernateUtil.get().openSession();

        repoAutor = new RepoAutor(session);
        repoLibro = new RepoLibro(session);
        repoTelefono = new RepoTelefono(session);

        mostrarMenu();

        session.close();
        System.out.println("Finalizando la conexion a MySQL");
    }

    public static void mostrarMenu() {
        int opcion = -1;
        do {
            System.out.println("\n1. Insertar nueva fila\n2. Borrar fila\n3. Consultar\n4. Salir");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1: {
                    mostrarMenuInsertar();
                    break;
                }
                case 2:{
                    mostrarMenuBorrar();
                    break;
                }
                case 3:{
                    mostrarMenuConsultas();
                    break;
                }
                case 4:{
                    System.exit(0);
                    break;
                }
            }
        }while(opcion != 4);
    }

    public static void mostrarMenuInsertar() {
        int opcion = -1;
        do {
            System.out.println("\n1. Insertar nuevo autor\n2. Insertar nuevo libro\n3. Enlazar autor-libro\n4. Insertar teléfono para un autor\n4. Atrás");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1: {
                    insertarAutor();
                    break;
                }
                case 2:{
                    insertarLibro();
                    break;
                }
                case 3:{
                    enlazarAutorLibro();
                    break;
                }
                case 4:{
                    insertarTelefonoAutor();
                    break;
                }
                case 5:{
                    break;
                }
            }
        }while(opcion < 1 || opcion > 5);
    }

    private static void insertarTelefonoAutor() {
        String dni = pedirString("Introduce el dni del usuario al que le quieras insertar el telefono: ");
        int numtlf = pedirInt("Introduce el número de telefono que deseas insertar al usuario: ");

        Telefono telefono = new Telefono(numtlf);
        Autor autor = repoAutor.consultarPorString(dni);

        autor.setTelefono(telefono);

        repoAutor.actualizar(autor);
        repoTelefono.insertarUno(telefono);
    }

    private static void enlazarAutorLibro() {
        String dni = pedirString("DNI del autor a enlazar: ");
        String titulo = pedirString("Titulo del libro a enlazar: ");

        Autor autor = repoAutor.consultarPorString(dni);
        Libro libro = repoLibro.consultarPorString(titulo);

        libro.addListaAutores(autor);
        repoAutor.actualizar(autor);
        repoLibro.actualizar(libro);
    }

    private static void insertarLibro() {
        String titulo = pedirString("Titulo del libro a insertar: ");
        System.out.println("Precio del libro a insertar: ");
        Double precio = Double.parseDouble(sc.nextLine());

        Libro libro = new Libro(titulo, precio);
        repoLibro.insertarUno(libro);
    }

    private static void insertarAutor() {
        String dni = pedirString("DNI del autor a insertar: ");
        String nombre = pedirString("Nombre del autor a insertar: ");
        String nacionalidad = pedirString("Nacionalidad del autor a insertar: ");
        Autor autor = new Autor(dni, nombre, nacionalidad);
        repoAutor.insertarUno(autor);
    }

    public static String pedirString(String mensaje) {
        System.out.println(mensaje);
        return sc.next();
    }

    public static int pedirInt(String mensaje) {
        System.out.println(mensaje);
        return sc.nextInt();
    }

    public static void mostrarMenuBorrar() {

        int opcion = -1;
        do {
            System.out.println("\n1. Borrar autor\n2. Borar libro\n3. Atrás");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1: {
                    String dni = pedirString("Introduzca el DNI del autor");
                    Autor autor = repoAutor.consultarPorString(dni);
                    repoAutor.borrar(autor);
                    break;
                }
                case 2:{
                    String titulo = pedirString("Introduzca el título del libro");
                    Libro libro = repoLibro.consultarPorString(titulo);
                    repoLibro.borrar(libro);
                    break;
                }
                case 3:{
                    break;
                }
            }
        }while(opcion < 1 || opcion > 3);
    }

    public static void mostrarMenuConsultas() {
        System.out.println("\n1. Visualizar datos de un libro a partir del título\n2. Visualizar libros de un determinado autor\n3. Visualizar todos los libros\n4. Visualizar todos los autores y sus libros\n5. Atrás");
        int opcion = -1;
        do {
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1: {
                    String titulo = pedirString("Introduzca el título de un libro");
                    Libro libro = repoLibro.consultarPorString(titulo);
                    System.out.println(libro.toString());
                    break;
                }
                case 2:{
                    String DNI = pedirString("Introduzca el DNI del autor");
                    Autor autor = repoAutor.consultarPorString(DNI);
                    for(Libro libro : autor.getListaLibros())
                        System.out.println(libro.toString());
                    break;
                }
                case 3:{
                    List<Libro> listaLibros = repoLibro.encontrarTodos();
                    for(Libro libro : listaLibros)
                        System.out.println(libro.toString());
                    break;
                }
                case 4:{
                    List<Autor> listaAutores = repoAutor.encontrarTodos();
                    for (Autor autor : listaAutores) {
                        System.out.println(autor.toString() + "\nLibros:");
                        for(Libro libro : autor.getListaLibros()) {
                            System.out.println(libro.toString());
                        }
                    }
                    break;
                }
                case 5:{
                    mostrarMenu();
                    break;
                }
            }
        }while(opcion < 1 || opcion > 5);
    }

}