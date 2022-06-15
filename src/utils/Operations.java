package utils;

import auxiliarEntities.BeerReviewsQuantity;
import auxiliarEntities.BreweryQuantity;
import auxiliarEntities.StyleArome;
import auxiliarEntities.UserReviewsQuantity;
import entities.*;
import uy.edu.um.prog2.adt.Hash.Bucket;
import uy.edu.um.prog2.adt.Hash.MyClosedHash;
import uy.edu.um.prog2.adt.Heap.EmptyHeapException;
import uy.edu.um.prog2.adt.Heap.HeapOverflow;
import uy.edu.um.prog2.adt.Heap.MyHeapMin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Operations {
    public static void top10Breweries(MyClosedHash<Long, Brewery> breweriesHash, Bucket<Long, Review>[] reviews,String year){
        long startTime = System.currentTimeMillis();
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
                    if(top10.top().compareTo(breweriesInYear.getBuckets()[i].getValue()) < 0){
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
        long stopTime = System.currentTimeMillis();
        long timeSpent = (stopTime - startTime);
        System.out.print("Time execution: ");
        System.out.print(timeSpent);
        System.out.println("ms");


    }
    public static void top15Users(Bucket<String, User>[] users){
        long startTime = System.currentTimeMillis();
        MyHeapMin<UserReviewsQuantity> top15 = new MyHeapMin<>(15);
        boolean isFull = false;
        int counter = 0;
        for(int i = 0; i < users.length; i++){
            if(users[i] != null){
                if(isFull){
                    if(users[i].getValue().getReviewIDs().getSize() > top15.top().getQuantity()){
                        try {
                            top15.delete();
                        } catch (EmptyHeapException e) {
                            e.printStackTrace();
                        }
                        try {
                            top15.insert(new UserReviewsQuantity(users[i].getKey(),users[i].getValue().getReviewIDs().getSize()));
                        } catch (HeapOverflow e) {
                            e.printStackTrace();
                        }
                    }
                }
                else{
                    try {
                        top15.insert(new UserReviewsQuantity(users[i].getKey(),users[i].getValue().getReviewIDs().getSize()));
                        counter++;
                        if(counter == 15){
                            isFull = true;
                        }
                    } catch (HeapOverflow e) {
                        e.printStackTrace();
                    }
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
    public static void reviewsBetweenDates(Bucket<Long, Review>[] reviews, Date initial, Date last){
        long startTime = System.currentTimeMillis();
        int reviewsInRange = 0;
        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
        Date reviewDate;
        for(int i = 0;i < reviews.length; i++){
            if(reviews[i] != null){
                try {
                    reviewDate = formatDate.parse(formatDate.format(reviews[i].getValue().getDate()));
                    if((reviewDate.after(initial) && reviewDate.before(last) || reviewDate.equals(initial) || reviewDate.equals(last))){
                        reviewsInRange++;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }

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
    public static void top7BeerStyles(Bucket<Long, Review>[] reviews){
        long startTime = System.currentTimeMillis();
        MyClosedHash<String, StyleArome> stylesRated = new MyClosedHash<>(1000);
        StyleArome auxiliarStyleArome;
        for(int i = 0; i < reviews.length; i++){
            if(reviews[i] != null){
                if(stylesRated.inHash(reviews[i].getValue().getStyle())){
                    stylesRated.get(reviews[i].getValue().getStyle()).addReview(reviews[i].getValue().getAromaScore());
                }
                else{
                    auxiliarStyleArome = new StyleArome(reviews[i].getValue().getStyle());
                    auxiliarStyleArome.addReview(reviews[i].getValue().getAromaScore());
                    stylesRated.put(reviews[i].getValue().getStyle(),auxiliarStyleArome);
                }
            }
        }

        MyHeapMin<StyleArome> top7 = new MyHeapMin<>(7);
        int counter = 0;
        boolean isFull = false;
        for(int i = 0; i < stylesRated.getBuckets().length; i++){
            if(stylesRated.getBuckets()[i] != null){
                if(isFull){
                    stylesRated.getBuckets()[i].getValue().calculateAverage();
                    if(top7.top().compareTo(stylesRated.getBuckets()[i].getValue()) < 0){
                        try {
                            top7.delete();
                        }catch (EmptyHeapException e){
                            e.printStackTrace();
                        }
                        try{
                            top7.insert(stylesRated.getBuckets()[i].getValue());
                        }catch (HeapOverflow e){
                            e.printStackTrace();
                        }
                    }
                }
                else{
                    try{
                        stylesRated.getBuckets()[i].getValue().calculateAverage();
                        top7.insert(stylesRated.getBuckets()[i].getValue());
                        counter++;
                        if(counter == 7){
                            isFull = true;
                        }
                    }catch (HeapOverflow e){
                        e.printStackTrace();
                    }

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
    public static void top5Beers(MyClosedHash<Long, Beer> beerHash, MyClosedHash<Long, Review> reviews){
        long startTime = System.currentTimeMillis();
        Bucket<Long,Beer>[] beers = beerHash.getBuckets();
        MyHeapMin<BeerReviewsQuantity> top5 = new MyHeapMin<>(5);
        boolean isFull = false;
        int counter = 0;
        for(int i = 0; i < beers.length; i++){
            if(beers[i] != null){
                if(isFull){
                    if(top5.top().getQuantity() < beers[i].getValue().getReviewIDs().size()){
                        try {
                            top5.delete();
                        } catch (EmptyHeapException e) {
                            e.printStackTrace();
                        }
                        try {
                            top5.insert(new BeerReviewsQuantity(beers[i].getKey(),beers[i].getValue().getReviewIDs().size()));
                        } catch (HeapOverflow e) {
                            e.printStackTrace();
                        }
                    }

                }
                else{
                    try {
                        top5.insert(new BeerReviewsQuantity(beers[i].getKey(),beers[i].getValue().getReviewIDs().size()));
                        counter++;
                        if(counter == 5){
                            isFull = true;
                        }
                    } catch (HeapOverflow e) {
                        e.printStackTrace();
                    }
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
            for(int j = 0; j < beerHash.get(beersTop5[i].getBeerID()).getReviewIDs().size(); j++){
                beerAvg += reviews.get(beerHash.get(beersTop5[i].getBeerID()).getReviewIDs().get(j)).getOverallScore();
            }
            System.out.print(i+1);
            System.out.print(", ");
            System.out.print("Beer Name: ");
            System.out.print(beerHash.get(beersTop5[i].getBeerID()).getName());
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
