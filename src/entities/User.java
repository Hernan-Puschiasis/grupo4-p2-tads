package entities;


import uy.edu.um.prog2.adt.LinkedList.LinkedList;

public class User{
    private String username;
    LinkedList<Long> reviewIDs = new LinkedList<>();
    public User(String username){
        this.username = username;
    }

    public void addReview(long reviewId){
        reviewIDs.add(reviewId);
    }

    public LinkedList<Long> getReviewIDs() {
        return reviewIDs;
    }
}
