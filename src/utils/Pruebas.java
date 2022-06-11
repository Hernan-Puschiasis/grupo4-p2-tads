package utils;

import auxiliarEntities.BreweryQuantity;
import uy.edu.um.prog2.adt.Heap.HeapOverflow;
import uy.edu.um.prog2.adt.Heap.MyHeapMax;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Pruebas {
    public static void main(String[] args) {
        Instant instant = Instant.ofEpochSecond(0);
        Date date = Date.from(instant);
        System.out.println(date.toString());
        SimpleDateFormat date2 = new SimpleDateFormat("yyyy");
        System.out.println(Integer.parseInt(date2.format(date)));
        MyHeapMax<BreweryQuantity> heap = new MyHeapMax<>(10);
        BreweryQuantity breweryQuantity = new BreweryQuantity(2);
        try{
            heap.insert(breweryQuantity);
            System.out.println();
        }catch (HeapOverflow e){

        }

    }
}
