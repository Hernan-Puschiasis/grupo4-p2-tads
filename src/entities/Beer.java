package entities;

import uy.edu.um.prog2.adt.LinkedList.LinkedList;

public class Beer {
    long id;
    String name;
    double abv;
    LinkedList<Long> reviewIDs = new LinkedList<>();
    Style style;

    public Beer(long id, String name, double abv, Style style){
        this.id = id;
        this.name = name;
        this.abv = abv;
        this.style = style;
    }

    public void addReview(long reviewID){
        reviewIDs.add(reviewID);
    }
}
