import com.opencsv.CSVReader;
import entities.*;
import uy.edu.um.prog2.adt.Hash.MyClosedHash;
import java.io.FileReader;
import static utils.uploadEntities.*;
import static utils.Operations.*;


public class Main {
    public MyClosedHash<String, User> users = new MyClosedHash<String,User>(10000);
    public MyClosedHash<Long, Beer> beers = new MyClosedHash<>(10000);
    public MyClosedHash<Long, Brewery> breweries = new MyClosedHash<>(10000);
    public MyClosedHash<Long, Review> reviews = new MyClosedHash<>(10000);
    public MyClosedHash<String,Style> styles = new MyClosedHash<>(10000);


    public static void main(String[] args) {
        Main main = new Main();
        main.uploadData();
        top10Breweries(main.breweries,main.reviews.getBuckets(),"2011");
        top5Beers(main.beers,main.reviews);
        top7BeerStyles(main.reviews.getBuckets());
    }

    public void uploadData(){
        long startTime = System.currentTimeMillis();
        try{
            FileReader reader = new FileReader("src/beer_dataset_test.csv");
            CSVReader csvReader = new CSVReader(reader);
            String[] line = csvReader.readNext();
            while ((line = csvReader.readNext()) != null) {
                if(!line[12].isEmpty()) {
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
}
