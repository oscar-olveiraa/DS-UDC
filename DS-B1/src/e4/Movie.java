package e4;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Movie {
    public String title;
    ArrayList<MovieRating> collection = new ArrayList();
    //MovieRating[] rating = MovieRating.values();

    public Movie(String title) {
        this.title = title;
    }

    public boolean rating(ArrayList<MovieRating> rating) {
        return collection.contains(rating);
    }

    public String getTitle() {
        return title;
    }

    public void insertRating(MovieRating movieRating) {
        collection.add(movieRating);
    }

    private boolean isRated() {
        return rating(collection);
    }

    public MovieRating maximumRating() {
        if(!isRated()) {
            return MovieRating.NOT_RATED;
        }else if(collection.contains(MovieRating.MASTERPIECE)){
            return MovieRating.MASTERPIECE;
        }else if(collection.contains(MovieRating.EXCELLENT)){
            return MovieRating.EXCELLENT;
        }else if(MovieRating.MEDIOCRE.isBetterThan(MovieRating.BAD)){
            return MovieRating.MEDIOCRE;
        }else{
            return MovieRating.AWFUL;
        }
    }

    /*public double averageRating() {
        int k = 0;
        int av = 0;
        //for (int i = 0; i < collection.size(); i++) {
        for(MovieRating rating : MovieRating.values()){
            if (rating[i] == MovieRating.NOT_RATED) {
                throw new NoSuchElementException("Ten que haber valoracions");
            }else{*/
                /*if(MovieRating.==rating.values()){
                    av+=rating.values();
                }else {
                    av += rating.ordinal();
                    k++;
                }
        }
        return (av/k);
    }*/
}
