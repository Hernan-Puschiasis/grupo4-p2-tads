package entities;

import java.util.Date;

public class Review {
    long id;
    Date date;
    double overallScore;
    double aromaScore;
    double appearanceScore;
    double flavourScore;
    long beer_id;
    long brewery_id;
    String style;

    public Review(long id, Date date, double overallScore, double aromaScore, double appearanceScore, double flavourScore,long beer_id,long brewery_id,String style){
        this.id = id;
        this.date = date;
        this.overallScore = overallScore;
        this.aromaScore = aromaScore;
        this.appearanceScore = appearanceScore;
        this.flavourScore = flavourScore;
        this.beer_id = beer_id;
        this.brewery_id = brewery_id;
        this.style = style;
    }

    public Date getDate() {
        return date;
    }

    public double getOverallScore() {
        return overallScore;
    }

    public double getAromaScore() {
        return aromaScore;
    }

    public long getBeer_id() {
        return beer_id;
    }

    public long getBrewery_id() {
        return brewery_id;
    }

    public String getStyle() {
        return style;
    }
}
