package e4;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Movie {
    public String title;
    MovieRating rating;
    List<MovieRating> collection = new ArrayList<>();


    public Movie(String title) {this.title = title;}

    //método auxiliar para o método  isRated()
    public boolean rating(MovieRating rating) {return collection.contains(rating);}

    public String getTitle() {return title;}

    public void insertRating(MovieRating movieRating) {collection.add(movieRating);}

    private boolean isRated() {return rating(rating);}

    public MovieRating maximumRating() {

        if (!isRated()) {
            rating= MovieRating.NOT_RATED;
        }
        /*
        if (collection.contains(MovieRating.MASTERPIECE)) {
            rating=MovieRating.MASTERPIECE;
        } else if (collection.contains(MovieRating.EXCELLENT)) {
            rating=MovieRating.EXCELLENT;
        } else if (collection.contains(MovieRating.GOOD)) {
            rating=MovieRating.GOOD;
        } else if(collection.contains(MovieRating.MEDIOCRE)){
            rating=MovieRating.MEDIOCRE;
        } else if(collection.contains(MovieRating.BAD)){
            rating=MovieRating.BAD;
        }
        */
        for(MovieRating e : collection){//Bucle de los elementos
            if(e == MovieRating.MASTERPIECE) return e; //Se p elemento ten a máxima valoración, devolvese
            else if(e.isBetterThan(rating)){ //Se non, imos comparando
                rating=e;                   //Actualizamos o novo elemento de maior valoracion
            }
        }
        return rating;//Devolvemos a maxima valoracion
    }

    public double averageRating() {
        int k=0;//Contador de peliculas valoradas
        int av=0;//Contador de valoracions
        for(MovieRating e : collection) { //Recorremos a colección de obxetos
            if (!(e == MovieRating.NOT_RATED)) {//Se a pelicula non está valorada, non a tenemos en conta para calcular a media
                av += e.getNumericRange();    //Imos aumentando o contador das valoracions
                k++;
            }
        }
        if(av==0){ //En caso de que non haxa valoracions
            throw new NoSuchElementException("Ten que haber valoracions");
        }
        return (double)(av)/(k);//Devolvemos a valoración media
    }
}