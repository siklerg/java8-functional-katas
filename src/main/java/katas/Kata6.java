package katas;


import model.BoxArt;
import model.Movie;
import util.DataUtil;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;


/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {

    private Kata6() {
        throw new IllegalStateException("Utility class");
    }

    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();
        BoxArt boxart = movies.stream()
                .flatMap(getBoxarts())
                .reduce(Kata6::getLargestBoxart)
                .orElseThrow(NoSuchElementException::new);
            return boxart.getUrl();
    }

    private static Function<Movie, Stream<BoxArt>> getBoxarts() {
        return movie -> movie.getBoxarts().stream();
    }

    private static BoxArt getLargestBoxart(BoxArt ba1, BoxArt ba2){
        return ba1.getWidth() > ba2.getWidth() ? ba1 : ba2;
    }
}
