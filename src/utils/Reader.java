package utils;
import com.opencsv.CSVReader;
import java.io.FileReader;
import static utils.uploadEntities.*;


public class Reader {
    public static void uploadData(){
        try{
            FileReader reader = new FileReader("/home/hernan/Desktop/Programacion/Prog2/Obligatorio/grupo4-p2-tads/src/beer_dataset_test.csv");
            CSVReader csvReader = new CSVReader(reader);
            String[] line = csvReader.readNext();

            int counter = 0;
            while ((line = csvReader.readNext()) != null) {
                //addReview();
            }
            reader.close();
            csvReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
