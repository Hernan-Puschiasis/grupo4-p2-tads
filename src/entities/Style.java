package entities;

import uy.edu.um.prog2.adt.ArrayList.ArrayList;
import uy.edu.um.prog2.adt.LinkedList.LinkedList;

public class Style {
    private String name;
    LinkedList<Long> beers = new LinkedList<>();
    ArrayList<Long>  reviewsAsociated = new ArrayList<>(100);
    public Style(String name){
        this.name = name;
    }

    public void addBeer(long beerID){
        beers.add(beerID);
    }

    public void addReview(long reviewID){reviewsAsociated.add(reviewID);}
}
