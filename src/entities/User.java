package entities;


import uy.edu.um.prog2.adt.LinkedList.LinkedList;
import uy.edu.um.prog2.adt.LinkedList.MyLinkedList;

public class User{
    private String username;
    private MyLinkedList<Long> reviewIDs = new LinkedList<>();
    public User(String username){
        this.username = username;
    }

    public void addReview(long reviewId){
        reviewIDs.add(reviewId);
    }

    public LinkedList<Long> getReviewIDs() {
        return (LinkedList<Long>) reviewIDs;
    }
}
