package entities;

import uy.edu.um.prog2.adt.LinkedList.LinkedList;

public class Brewery {
    long id;
    String name;
    LinkedList<Long> reviewIDs = new LinkedList<>();
    //TODO: capaz tiene que ser un set LinkedList<Long> beers = new LinkedList<>();

    public Brewery(long id, String name){
        this.id = id;
        this.name = name;
    }

    public void addReview(long reviewID){reviewIDs.add(reviewID);}
    //public void add
}
