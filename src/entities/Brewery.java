package entities;

import uy.edu.um.prog2.adt.LinkedList.LinkedList;
import uy.edu.um.prog2.adt.LinkedList.MyLinkedList;

public class Brewery {
    private long id;
    private String name;
    MyLinkedList<Long> reviewIDs = new LinkedList<>();

    public Brewery(long id, String name){
        this.id = id;
        this.name = name;
    }

    public void addReview(long reviewID){reviewIDs.add(reviewID);}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LinkedList<Long> getReviewIDs() {
        return (LinkedList<Long>) reviewIDs;
    }
}
