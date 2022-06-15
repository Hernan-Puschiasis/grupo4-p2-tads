package utils;

import auxiliarEntities.BreweryQuantity;
import uy.edu.um.prog2.adt.Heap.HeapOverflow;
import uy.edu.um.prog2.adt.Heap.MyHeapMax;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Pruebas {
    public static void main(String[] args) {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
        formatDate.setLenient(false);
        try {
            Date date = formatDate.parse("22-12-2021");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
