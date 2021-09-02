package katas;

import model.Movie;
import util.DataUtil;

import java.util.*;
import java.util.stream.*;

/*
    Goal: Chain filter() and map() to collect the ids of videos that have a rating of 5.0
    DataSource: DataUtil.getMovies()
    Output: List of Integers
*/
public class Kata2 {

    private Kata2() {
        throw new IllegalStateException("Utility class");
    }

    public static List<Integer> execute() {
        List<Movie> movies = DataUtil.getMovies();
        return movies.stream()
                .filter(movie -> movie.getRating() == 5.0)
                .map(Movie::getId)
                .collect(Collectors.toList());
    }
}
