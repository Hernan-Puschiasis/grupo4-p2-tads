package entities;
import java.util.Scanner;

public class Utils {
    private static String input;
    private static final Scanner myObj = new Scanner(System.in);  // Crea un objeto Scanner.

    public static void displayMenu() {
        while (!input.equals("2")){
            System.out.println("Bienvenido. Ingrese el número correspondiente a lo que desea realizar: ");
            System.out.println("1- Cargar datos y menú de consultas. ");
            System.out.println("2- Finalizar.");
            System.out.println();
            input = myObj.next();
            switch (input){
                case "1":
//                  función cargar datos.
                    System.out.println("Carga completa.");
                    submenu(); //entro al submenu.
                    break;

                case "2":
                    break;

                default:
                    System.out.println("Opción incorrecta. Intente de nuevo.");
            }
        }
    }

    public static void submenu(){

        while(!input.equals("6")){
            System.out.println("Ingrese el número de consulta que desea realizar:");
            System.out.println("1- Top 10 casas de cervezas.");
            System.out.println("2- Top 15 catadores con más reseñas.");
            System.out.println("3- Cantidad de reviews por rango. ");
            System.out.println("4- Top 7 estilos de cervezas con mejor aroma.");
            System.out.println("5- Top 5 cervezas con más reviews.");
            System.out.println("6- Finalizar.");
            input = myObj.next();

            switch(input){
                case "1":
//                    función "Top 10 casas de cervezas".
                    break;

                case "2":
//                    función "Top 15 catadores con más reseñas".
                    break;

                case "3":
//                    función "Cantidad de reviews por rango".
                    break;

                case "4":
//                    función "Top 7 estilos de cervezas con mejor aroma".
                    break;

                case "5":
//                    función "Top 5 cervezas con más reviews.".
                    break;

                case "6":
                    break;

                default:
                    System.out.println("Opción incorrecta. Intente de nuevo.");
                    break;

            }
        }
    }
}
