package entities;

import uy.edu.um.prog2.adt.ArrayList.ArrayList;
import uy.edu.um.prog2.adt.ArrayList.MyArrayList;
import uy.edu.um.prog2.adt.LinkedList.LinkedList;
import uy.edu.um.prog2.adt.LinkedList.MyLinkedList;

public class Style {
    private String name;
    MyLinkedList<Long> beers = new LinkedList<>();
    MyArrayList<Long> reviewsAsociated = new ArrayList<>(100);
    public Style(String name){
        this.name = name;
    }

    public void addBeer(long beerID){
        beers.add(beerID);
    }

    public void addReview(long reviewID){reviewsAsociated.add(reviewID);}
}
