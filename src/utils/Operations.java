package utils;

import auxiliarEntities.BreweryQuantity;
import entities.*;
import uy.edu.um.prog2.adt.Hash.Bucket;
import uy.edu.um.prog2.adt.Hash.MyClosedHash;
import uy.edu.um.prog2.adt.Heap.EmptyHeapException;
import uy.edu.um.prog2.adt.Heap.HeapOverflow;
import uy.edu.um.prog2.adt.Heap.MyHeapMin;

import java.text.SimpleDateFormat;
import java.util.Date;
//System.currentTimeMillis()
public class Operations {
    public static void top10Breweries(MyClosedHash<Long, Brewery> breweriesHash, Bucket<Long, Review>[] reviews,String year){
        long startTime = System.nanoTime();
        Bucket<Long, Brewery>[] breweries = breweriesHash.getBuckets();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy");
        MyClosedHash<Long, BreweryQuantity> breweriesInYear = new MyClosedHash<>(1000);
        for(int i = 0; i < reviews.length; i++){
            if(reviews[i] != null && formatDate.format(reviews[i].getValue().getDate()).equals(year)){
                if(breweriesInYear.inHash(reviews[i].getValue().getBrewery_id())){
                    breweriesInYear.get(reviews[i].getValue().getBrewery_id()).addQuantity();
                }
                else{
                    breweriesInYear.put(reviews[i].getValue().getBrewery_id(),new BreweryQuantity(reviews[i].getValue().getBrewery_id()));
                }
            }
        }

        MyHeapMin<BreweryQuantity> top10 = new MyHeapMin<>(10);
        int counter = 0;
        boolean isFull = false;
        for(int i = 0; i < breweriesInYear.getBuckets().length; i++){
            if(breweriesInYear.getBuckets()[i] != null){
                if(isFull){
                    if(top10.min().compareTo(breweriesInYear.getBuckets()[i].getValue()) < 0){
                        try {
                            top10.delete();
                        }catch (EmptyHeapException e){
                            e.printStackTrace();
                        }
                        try{
                            top10.insert(breweriesInYear.getBuckets()[i].getValue());
                        }catch (HeapOverflow e){
                            e.printStackTrace();
                        }
                    }
                }
                else{
                    try{
                        top10.insert(breweriesInYear.getBuckets()[i].getValue());
                        counter++;
                        if(counter == 10){
                            isFull = true;
                        }
                    }catch (HeapOverflow e){
                        e.printStackTrace();
                    }

                }
            }
        }
        BreweryQuantity[] breweriesTop10 = new BreweryQuantity[top10.size()];
        for(int i = breweriesTop10.length - 1; i >= 0 ;i--){
            try {
                breweriesTop10[i] = top10.delete();
            }catch (EmptyHeapException e){
                e.printStackTrace();
            }
        }
        for(int i = 0; i < breweriesTop10.length; i++){
            System.out.print(i+1);
            System.out.print(", ");
            System.out.print("Brewery ID: ");
            System.out.print(breweriesTop10[i].getBreweryID());
            System.out.print(", ");
            System.out.print("Brewery Name: ");
            System.out.print(breweriesHash.get(breweriesTop10[i].getBreweryID()).getName());
            System.out.print(", ");
            System.out.print("Reviews: ");
            System.out.println(breweriesTop10[i].getQuantity());
        }
        long stopTime = System.nanoTime();
        long timeSpent = (stopTime - startTime)/1000000;
        System.out.print("Time execution: ");
        System.out.print(timeSpent);
        System.out.println("ms");


    }
    public static void top15Users(Bucket<Long, User>[] users){

    }
    public static void reviewsBetweenDates(Bucket<Long, Review>[] reviews, Date initial, Date last){

    }
    public static void top7BeerStyles(Bucket<String, Style>[] styles, Bucket<Long, Review>[] reviews, Bucket<Long, Beer>[] beers){

    }
    public static void top5Beers(Bucket<Long, Beer>[] beers, Bucket<Long, Review>[] reviews){

    }


}
