package utils;
import com.opencsv.CSVReader;
import java.io.FileReader;

public class Reader {
    public static void uploadData(){
        try{
            FileReader reader = new FileReader("/home/hernan/Desktop/Programacion/Prog2/Obligatorio/grupo4-p2-tads/src/beer_dataset_test.csv");
            CSVReader csvReader = new CSVReader(reader);
            String[] line = csvReader.readNext();

            int counter = 0;
            while ((line = csvReader.readNext()) != null) {
                if(counter < 3){
                    System.out.print(counter);
                    System.out.println(line[0] + " " + line[1] + " " + line[2]);
                }
                counter++;
            }
            reader.close();
            csvReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
