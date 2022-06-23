package utils;

import entities.*;
import uy.edu.um.prog2.adt.Hash.MyHash;

import java.time.Instant;
import java.util.Date;

public class UploadEntities {
    public static void addUser(MyHash<String, User> users, String[] line){
        if(users.inHash(line[7])){
            users.get(line[7]).addReview(Long.parseLong(line[0]));
        }
        else{
            User newUser = new User(line[7]);
            newUser.addReview(Long.parseLong(line[0]));
            users.put(line[7],newUser);
        }
    }

    public static void addBeer(MyHash<Long, Beer> beers, String[] line){
        if(beers.inHash(Long.parseLong(line[13]))){
            beers.get(Long.parseLong(line[13])).addReview(Long.parseLong(line[0]));
        }
        else{
            Style beerStyle = new Style(line[8]);
            Beer newBeer = new Beer(Long.parseLong(line[13]),line[11],Double.parseDouble(line[12]),beerStyle);
            newBeer.addReview(Long.parseLong(line[0]));
            beers.put(Long.parseLong(line[13]),newBeer);
        }
    }

    public static void addBrewery(MyHash<Long, Brewery> breweries, String[] line){
        if(breweries.inHash(Long.parseLong(line[1]))){
            breweries.get(Long.parseLong(line[1])).addReview(Long.parseLong(line[0]));
        }
        else{
            Brewery newBrewery = new Brewery(Long.parseLong(line[1]),line[2]);
            newBrewery.addReview(Long.parseLong(line[0]));
            breweries.put(Long.parseLong(line[1]),newBrewery);
        }
    }

    public static void addReview(MyHash<Long, Review> reviews, String[] line){
        Instant newInstant = Instant.ofEpochSecond(Long.parseLong(line[3]));
        Date newDate = Date.from(newInstant);
        Review newReview = new Review(Long.parseLong(line[0]),newDate,Double.parseDouble(line[4]),
                Double.parseDouble(line[5]),Double.parseDouble(line[6]),Double.parseDouble(line[10]),
                Long.parseLong(line[13]),Long.parseLong(line[1]),line[8]);
        reviews.put(Long.parseLong(line[0]),newReview);
    }

    public static void addStyle(MyHash<String, Style> styles, String[] line){
        if(styles.inHash(line[8])){
            styles.get(line[8]).addBeer(Long.parseLong(line[13]));
        }
        else{
            Style newStyle = new Style(line[8]);
            newStyle.addBeer(Long.parseLong(line[13]));
            newStyle.addReview(Long.parseLong(line[0]));
            styles.put(line[8],newStyle);
        }
    }
}
