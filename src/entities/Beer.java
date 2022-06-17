package entities;

import uy.edu.um.prog2.adt.ArrayList.ArrayList;
import uy.edu.um.prog2.adt.LinkedList.LinkedList;

public class Beer {
    private long id;
    private String name;
    private double abv;
    ArrayList<Long> reviewIDs = new ArrayList<>(100);
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

    public ArrayList<Long> getReviewIDs(){
        return reviewIDs;
    }

    public String getName() {
        return name;
    }
}
