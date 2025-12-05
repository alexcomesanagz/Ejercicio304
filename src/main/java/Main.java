import org.hibernate.Session;

import java.util.Scanner;

public class Main {

    private static Scanner sc;

    public static void main(String[] args) {
        System.out.println("Test");

        Session session = HibernateUtil.get().openSession();

        mostrarMenu();

        session.close();
        System.out.println("Finalizando la conexion a MySQL");
    }

    public static void mostrarMenu() {
        int opcion = -1;
        do {
            System.out.println("\n1. Insertar nueva fila\n2. Borrar fila\n3. Consultar\n4. Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1: {
                    mostrarMenuInsertar();
                    break;
                }
                case 2:{
                    //mostrarMenuBorrar();
                    break;
                }
                case 3:{
                    //mostrarMenuConsultas();
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
            opcion = sc.nextInt();
            switch (opcion) {
                case 1: {
                    //insertarAutor(false);
                    break;
                }
                case 2:{
                    //insertarLibro(false);
                    break;
                }
                case 3:{
                    //enlazarAutorLibro();
                    break;
                }
                case 4:{
                    //insertarTelefonoAutor();
                    break;
                }
                case 5:{
                    break;
                }
            }
        }while(opcion < 1 || opcion > 5);
    }


    public static String pedirString(String mensaje) {
        System.out.println(mensaje);
        return sc.next();
    }

    public int pedirInt(String mensaje) {
        System.out.println(mensaje);
        return sc.nextInt();
    }

}