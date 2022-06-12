package auxiliarEntities;

public class BeerReviewsQuantity implements Comparable<BeerReviewsQuantity>{
    long beerID;
    int quantity;

    public BeerReviewsQuantity(long beerID, int quantity) {
        this.beerID = beerID;
        this.quantity = quantity;
    }

    public long getBeerID() {
        return beerID;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public int compareTo(BeerReviewsQuantity beerReviewsQuantity) {
        if(quantity > beerReviewsQuantity.getQuantity()){
            return 1;
        }
        else if(quantity < beerReviewsQuantity.getQuantity()){
            return -1;
        }
        else{
            return 0;
        }
    }
}
