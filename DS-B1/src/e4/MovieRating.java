package e4;

public enum MovieRating { //Enumerado de valoracions
    NOT_RATED (-1),
    AWFUL (0),
    BAD (2),
    MEDIOCRE (4),
    GOOD (6),
    EXCELLENT (8),
    MASTERPIECE (10);

    private final int range;

    public int getNumericRange(){return range;}

    MovieRating(int range){

        this.range=range;
    }

    boolean isBetterThan(MovieRating rating) {
        /*
        if (MovieRating.NOT_RATED.ordinal() < rating.ordinal()) {
            return true;
        } else if (MovieRating.AWFUL.ordinal() > rating.ordinal()) {
            return true;
        } else if (MovieRating.BAD.ordinal() > rating.ordinal()) {
            return true;
        } else if (MovieRating.MEDIOCRE.ordinal() > rating.ordinal()) {
            return true;
        } else if (MovieRating.GOOD.ordinal() > rating.ordinal()) {
            return true;
        } else if (MovieRating.EXCELLENT.ordinal() > rating.ordinal()) {
            return true;
        } else
            return false;
        */

        if(this.range>rating.ordinal()){
            return true;
        }else{
            return false;
        }
    }
}
