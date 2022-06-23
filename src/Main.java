import com.opencsv.CSVReader;
import entities.*;
import uy.edu.um.prog2.adt.Hash.MyClosedHash;
import uy.edu.um.prog2.adt.Hash.MyHash;

import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Scanner;
import static utils.UploadEntities.*;
import static utils.Operations.*;


public class Main {
    public MyHash<String, User> users;
    public MyHash<Long, Beer> beers;
    public MyHash<Long, Brewery> breweries;
    public MyHash<Long, Review> reviews;
    public MyHash<String,Style> styles;
    private static String input = "-1";
    private static final Scanner myObj = new Scanner(System.in);

    public Main(){
        users = new MyClosedHash<String,User>(80000);
        beers = new MyClosedHash<>(80000);
        breweries = new MyClosedHash<>(10000);
        reviews = new MyClosedHash<>(2100000);
        styles = new MyClosedHash<>(500);

    }
    public static void main(String[] args) {
        Main main = new Main();
        main.displayMenu(main);
    }

    public void uploadData(){
        long startTime = System.currentTimeMillis();
        try{
            FileReader reader = new FileReader("src/beer_dataset_full.csv");
            CSVReader csvReader = new CSVReader(reader);
            String[] line = csvReader.readNext();
            while ((line = csvReader.readNext()) != null) {
                if(!line[12].isEmpty() && !line[0].isEmpty() && !line[1].isEmpty() &&
                        !line[2].isEmpty() && !line[3].isEmpty() && !line[4].isEmpty() &&
                        !line[5].isEmpty() && !line[6].isEmpty() && !line[7].isEmpty() &&
                        !line[8].isEmpty() && !line[9].isEmpty() && !line[10].isEmpty() &&
                        !line[11].isEmpty() && !line[13].isEmpty()) {
                    addReview(reviews, line);
                    addBeer(beers, line);
                    addBrewery(breweries, line);
                    addStyle(styles, line);
                    addUser(users, line);
                }
            }
            reader.close();
            csvReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        long stopTime = System.currentTimeMillis();
        long timeSpent = (stopTime - startTime);
        System.out.print("Time execution: ");
        System.out.print(timeSpent);
        System.out.println("ms");
    }

    public void displayMenu(Main main) {
        while (!(input.equals("1"))){
            System.out.println("Bienvenido. Ingrese el número correspondiente a lo que desea realizar: ");
            System.out.println("1- Cargar datos y menú de consultas. ");
            System.out.println();
            input = myObj.next();
            switch (input){
                case "1":
                    main.uploadData();
                    System.out.println("Carga completa.");
                    main.submenu(main,input);
                    break;

                default:
                    System.out.println("Opción incorrecta. Intente de nuevo.");
            }
        }
    }

    public void submenu(Main main,String input){
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
                    try{
                        System.out.println("Ingrese un año: ");
                        String newInput = myObj.next();
                        Integer year = Integer.parseInt(newInput);
                        top10Breweries(breweries, reviews,newInput);
                    }catch (NumberFormatException e){
                        System.out.println("Año erróneo, consulte de nuevo");
                    }
                    break;

                case "2":
                    top15Users(main.users);
                    break;

                case "3":
                    SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
                    formatDate.setLenient(false);
                    try {
                        System.out.println("Ingrese una fecha inicio: dd-MM-yyyy");
                        String newDate = myObj.next();
                        System.out.println("Ingrese una fecha final: dd-MM-yyyy");
                        String finalDate = myObj.next();

                        if(formatDate.parse(finalDate).before(formatDate.parse(newDate))){
                            System.out.println("Error en las fechas. Ingrese de nuevo");
                        }
                        else{
                            reviewsBetweenDates(reviews,formatDate.parse(newDate).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),formatDate.parse(finalDate).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                        }
                    } catch (ParseException e) {
                        System.out.println("Error en las fechas. Ingrese de nuevo");
                    }
                    break;

                case "4":
                    top7BeerStyles(reviews);
                    break;

                case "5":
                    top5Beers(beers,reviews);
                    break;

                case "6":
                    break;

                default:
                    System.out.println("Opción incorrecta. Intente de nuevo.");
                    break;

            }
        }
        input = "1";
    }

}
