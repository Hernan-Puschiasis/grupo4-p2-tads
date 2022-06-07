package entities;

import java.util.Date;

public class Review {
    long id;
    Date date;
    double overallScore;
    double aromaScore;
    double appearanceScore;
    double flavourScore;

    public Review(long id, Date date, double overallScore, double aromaScore, double appearanceScore, double flavourScore){
        this.id = id;
        this.date = date;
        this.overallScore = overallScore;
        this.aromaScore = aromaScore;
        this.appearanceScore = appearanceScore;
        this.flavourScore = flavourScore;
    }
}
