package auxiliarEntities;

public class BreweryQuantity implements Comparable<BreweryQuantity> {
    private long breweryID;
    private int quantity = 1;

    public BreweryQuantity(long breweryID) {
        this.breweryID = breweryID;
    }

    public long getBreweryID() {
        return breweryID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(){
        quantity++;
    }


    @Override
    public int compareTo(BreweryQuantity breweryQuantity) {
        if(quantity > breweryQuantity.getQuantity()){
            return 1;
        }
        else if(quantity < breweryQuantity.quantity){
            return -1;
        }
        else{
            return 0;
        }
    }
}
