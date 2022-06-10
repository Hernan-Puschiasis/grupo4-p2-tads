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

    public Review(long id, Date date, double overallScore, double aromaScore, double appearanceScore, double flavourScore,long beer_id,long brewery_id){
        this.id = id;
        this.date = date;
        this.overallScore = overallScore;
        this.aromaScore = aromaScore;
        this.appearanceScore = appearanceScore;
        this.flavourScore = flavourScore;
        this.beer_id = beer_id;
        this.brewery_id = brewery_id;
    }
}
