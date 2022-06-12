package auxiliarEntities;

public class StyleArome implements Comparable<StyleArome>{
    private String Style;
    private double sum = 0;
    private int quantity = 0;
    private double average;

    public StyleArome(String style) {
        Style = style;
    }

    @Override
    public int compareTo(StyleArome styleArome) {
        if(average > styleArome.getAverage()){
            return 1;
        }
        else if(average < styleArome.getAverage()){
            return -1;
        }
        else{
            return 0;
        }
    }

    public void addReview(double score){
        quantity++;
        sum += score;
    }
    public void calculateAverage(){
        average = sum/quantity;
    }
    public String getStyle() {
        return Style;
    }

    public double getSum() {
        return sum;
    }

    public float getQuantity() {
        return quantity;
    }

    public double getAverage() {
        return average;
    }
}
