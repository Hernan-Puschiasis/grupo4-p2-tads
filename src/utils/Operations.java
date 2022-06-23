package utils;

import auxiliarEntities.BeerReviewsQuantity;
import auxiliarEntities.BreweryQuantity;
import auxiliarEntities.StyleArome;
import auxiliarEntities.UserReviewsQuantity;
import entities.*;
import uy.edu.um.prog2.adt.Hash.Bucket;
import uy.edu.um.prog2.adt.Hash.MyClosedHash;
import uy.edu.um.prog2.adt.Hash.MyHash;
import uy.edu.um.prog2.adt.Heap.EmptyHeapException;
import uy.edu.um.prog2.adt.Heap.HeapOverflow;
import uy.edu.um.prog2.adt.Heap.MyHeap;
import uy.edu.um.prog2.adt.Heap.MyHeapMin;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

public class Operations {
    public static void top10Breweries(MyHash<Long, Brewery> breweriesHash, MyHash<Long, Review> reviews, String year){
        long startTime = System.currentTimeMillis();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy");
        MyHash<Long, BreweryQuantity> breweriesInYear = new MyClosedHash<>(1000);
        for(int i = 0; i < reviews.getKeys().size(); i++){
            if(formatDate.format(reviews.get(reviews.getKeys().get(i)).getDate()).equals(year)){
                if(breweriesInYear.inHash(reviews.get(reviews.getKeys().get(i)).getBrewery_id())){
                    breweriesInYear.get(reviews.get(reviews.getKeys().get(i)).getBrewery_id()).addQuantity();
                }
                else{
                    breweriesInYear.put(reviews.get(reviews.getKeys().get(i)).getBrewery_id(),new BreweryQuantity(reviews.get(reviews.getKeys().get(i)).getBrewery_id()));
                }
            }
        }

        MyHeap<BreweryQuantity> top10 = new MyHeapMin<>(10);
        int counter = 0;
        boolean isFull = false;
        for(int i = 0; i < breweriesInYear.getKeys().size(); i++){
            if(isFull){
                if(top10.top().compareTo(breweriesInYear.get(breweriesInYear.getKeys().get(i))) < 0){
                    try {
                        top10.delete();
                    }catch (EmptyHeapException e){
                        e.printStackTrace();
                    }
                    try{
                        top10.insert(breweriesInYear.get(breweriesInYear.getKeys().get(i)));
                    }catch (HeapOverflow e){
                        e.printStackTrace();
                    }
                }
            }
            else{
                try{
                    top10.insert(breweriesInYear.get(breweriesInYear.getKeys().get(i)));
                    counter++;
                    if(counter == 10){
                        isFull = true;
                    }
                }catch (HeapOverflow e){
                    e.printStackTrace();
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
        long stopTime = System.currentTimeMillis();
        long timeSpent = (stopTime - startTime);
        System.out.print("Time execution: ");
        System.out.print(timeSpent);
        System.out.println("ms");


    }
    public static void top15Users(MyHash<String, User> users){
        long startTime = System.currentTimeMillis();
        MyHeap<UserReviewsQuantity> top15 = new MyHeapMin<>(15);
        boolean isFull = false;
        int counter = 0;
        for(int i = 0; i < users.getKeys().size(); i++){
            if(isFull){
                if(users.get(users.getKeys().get(i)).getReviewIDs().getSize() > top15.top().getQuantity()){
                    try {
                        top15.delete();
                    } catch (EmptyHeapException e) {
                        e.printStackTrace();
                    }
                    try {
                        top15.insert(new UserReviewsQuantity(users.getKeys().get(i),users.get(users.getKeys().get(i)).getReviewIDs().getSize()));
                    } catch (HeapOverflow e) {
                        e.printStackTrace();
                    }
                }
            }
            else{
                try {
                    top15.insert(new UserReviewsQuantity(users.getKeys().get(i),users.get(users.getKeys().get(i)).getReviewIDs().getSize()));
                    counter++;
                    if(counter == 15){
                        isFull = true;
                    }
                } catch (HeapOverflow e) {
                    e.printStackTrace();
                }
            }
        }
        UserReviewsQuantity[] usersTop15 = new UserReviewsQuantity[top15.size()];
        for(int i = usersTop15.length - 1; i >= 0 ;i--){
            try {
                usersTop15[i] = top15.delete();
            }catch (EmptyHeapException e){
                e.printStackTrace();
            }
        }
        for(int i = 0; i < usersTop15.length; i++){
            System.out.print(i+1);
            System.out.print(", ");
            System.out.print("Username: ");
            System.out.print(usersTop15[i].getUsername());
            System.out.print(", ");
            System.out.print("Reviews: ");
            System.out.println(usersTop15[i].getQuantity());
        }
        long stopTime = System.currentTimeMillis();
        long timeSpent = (stopTime - startTime);
        System.out.print("Time execution: ");
        System.out.print(timeSpent);
        System.out.println("ms");
    }
    public static void reviewsBetweenDates(MyHash<Long, Review> reviews, LocalDate initial, LocalDate last){
        long startTime = System.currentTimeMillis();
        int reviewsInRange = 0;
        LocalDate reviewDate;

        for(int i = 0;i < reviews.getKeys().size(); i++){
                reviewDate = reviews.get(reviews.getKeys().get(i)).getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                if((reviewDate.isAfter(initial) && reviewDate.isBefore(last) || reviewDate.isEqual(initial) || reviewDate.isEqual(last))){
                    reviewsInRange++;
                }
        }
        System.out.print("Reviews: ");
        System.out.println(reviewsInRange);
        long stopTime = System.currentTimeMillis();
        long timeSpent = (stopTime - startTime);
        System.out.print("Time execution: ");
        System.out.print(timeSpent);
        System.out.println("ms");
    }
    public static void top7BeerStyles(MyHash<Long, Review> reviews){
        long startTime = System.currentTimeMillis();
        MyHash<String, StyleArome> stylesRated = new MyClosedHash<>(1000);
        StyleArome auxiliarStyleArome;
        for(int i = 0; i < reviews.getKeys().size(); i++){
            if(stylesRated.inHash(reviews.get(reviews.getKeys().get(i)).getStyle())){
                stylesRated.get(reviews.get(reviews.getKeys().get(i)).getStyle()).addReview(reviews.get(reviews.getKeys().get(i)).getAromaScore());
            }
            else{
                auxiliarStyleArome = new StyleArome(reviews.get(reviews.getKeys().get(i)).getStyle());
                auxiliarStyleArome.addReview(reviews.get(reviews.getKeys().get(i)).getAromaScore());
                stylesRated.put(reviews.get(reviews.getKeys().get(i)).getStyle(),auxiliarStyleArome);
            }
        }

        MyHeap<StyleArome> top7 = new MyHeapMin<>(7);
        int counter = 0;
        boolean isFull = false;
        for(int i = 0; i < stylesRated.getKeys().size(); i++){
            if(isFull){
                stylesRated.get(stylesRated.getKeys().get(i)).calculateAverage();
                if(top7.top().compareTo(stylesRated.get(stylesRated.getKeys().get(i))) < 0){
                    try {
                        top7.delete();
                    }catch (EmptyHeapException e){
                        e.printStackTrace();
                    }
                    try{
                        top7.insert(stylesRated.get(stylesRated.getKeys().get(i)));
                    }catch (HeapOverflow e){
                        e.printStackTrace();
                    }
                }
            }
            else{
                try{
                    stylesRated.get(stylesRated.getKeys().get(i)).calculateAverage();
                    top7.insert(stylesRated.get(stylesRated.getKeys().get(i)));
                    counter++;
                    if(counter == 7){
                        isFull = true;
                    }
                }catch (HeapOverflow e){
                    e.printStackTrace();
                }

            }
        }
        StyleArome[] beersTop7 = new StyleArome[top7.size()];
        for(int i = beersTop7.length - 1; i >= 0 ;i--){
            try {
                beersTop7[i] = top7.delete();
            }catch (EmptyHeapException e){
                e.printStackTrace();
            }
        }
        for(int i = 0; i < beersTop7.length; i++){
            System.out.print(i+1);
            System.out.print(", ");
            System.out.print("Beer Style: ");
            System.out.print(beersTop7[i].getStyle());
            System.out.print(", ");
            System.out.print("Arome Average Score: ");
            System.out.println(beersTop7[i].getAverage());
        }
        long stopTime = System.currentTimeMillis();
        long timeSpent = (stopTime - startTime);
        System.out.print("Time execution: ");
        System.out.print(timeSpent);
        System.out.println("ms");
    }
    public static void top5Beers(MyHash<Long, Beer> beers, MyHash<Long, Review> reviews){
        long startTime = System.currentTimeMillis();
        MyHeap<BeerReviewsQuantity> top5 = new MyHeapMin<>(5);
        boolean isFull = false;
        int counter = 0;
        for(int i = 0; i < beers.getKeys().size(); i++){
            if(isFull){
                if(top5.top().getQuantity() < beers.get(beers.getKeys().get(i)).getReviewIDs().size()){
                    try {
                        top5.delete();
                    } catch (EmptyHeapException e) {
                        e.printStackTrace();
                    }
                    try {
                        top5.insert(new BeerReviewsQuantity(beers.getKeys().get(i),beers.get(beers.getKeys().get(i)).getReviewIDs().size()));
                    } catch (HeapOverflow e) {
                        e.printStackTrace();
                    }
                }

            }
            else{
                try {
                    top5.insert(new BeerReviewsQuantity(beers.getKeys().get(i),beers.get(beers.getKeys().get(i)).getReviewIDs().size()));
                    counter++;
                    if(counter == 5){
                        isFull = true;
                    }
                } catch (HeapOverflow e) {
                    e.printStackTrace();
                }
            }
        }

        BeerReviewsQuantity[] beersTop5 = new BeerReviewsQuantity[top5.size()];
        for(int i = beersTop5.length - 1; i >= 0 ;i--){
            try {
                beersTop5[i] = top5.delete();
            }catch (EmptyHeapException e){
                e.printStackTrace();
            }
        }
        for(int i = 0; i < beersTop5.length; i++){
            float beerAvg = 0;
            for(int j = 0; j < beers.get(beersTop5[i].getBeerID()).getReviewIDs().size(); j++){
                beerAvg += reviews.get(beers.get(beersTop5[i].getBeerID()).getReviewIDs().get(j)).getOverallScore();
            }
            System.out.print(i+1);
            System.out.print(", ");
            System.out.print("Beer Name: ");
            System.out.print(beers.get(beersTop5[i].getBeerID()).getName());
            System.out.print(", ");
            System.out.print("Reviews: ");
            System.out.print(beersTop5[i].getQuantity());
            System.out.print(", ");
            System.out.print("Overall Score Average: ");
            System.out.println(beerAvg/beersTop5[i].getQuantity());
        }
        long stopTime = System.currentTimeMillis();
        long timeSpent = (stopTime - startTime);
        System.out.print("Time execution: ");
        System.out.print(timeSpent);
        System.out.println("ms");

    }


}
