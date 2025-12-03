import org.hibernate.Session;

import java.util.Scanner;

public class Main {

    private static Scanner sc;

    public static void main(String[] args) {
        System.out.println("Test");

        Session session = HibernateUtil.get().openSession();

        int opcion;
        do {
            showMenuGeneral();
            opcion =Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> MenuInsercion();
//                case 2 ->
//                    case 3 ->
//                        default ->
            }
        }while(opcion!=0);

        session.close();
        System.out.println("Finalizando la conexion a MySQL");
    }

    private static void showMenuGeneral(){
        System.out.println("--- SELECCIONE UNA DE LAS SIGUIENTES OPCIONES ---");
        System.out.println("1. Insección de una nueva fila.");
        System.out.println("2. Borrado de filas.");
        System.out.println("3. Consultar.");
        System.out.println("0. Salir.");
        System.out.println("-------------------------------------------------");
    }

    private static void MenuInsercion(){
        System.out.println("--- SELECCIONE UNA DE LAS SIGUIENTES OPCIONES ---");
        System.out.println("1. Inserción de nuevo autor.");
        System.out.println("2. Inserción de nuevo libro.");
        System.out.println("3. Consultar.");
        System.out.println("4. Consultar.");
        System.out.println("0. Salir.");
        System.out.println("-------------------------------------------------");
    }

}