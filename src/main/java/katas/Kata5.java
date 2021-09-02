package katas;


import model.Movie;
import util.DataUtil;

import java.util.*;
import java.util.stream.*;

/*
    Goal: Retrieve the largest rating using reduce()
    DataSource: DataUtil.getMovies()
    Output: Double
*/
public class Kata5 {

    private Kata5() {
        throw new IllegalStateException("Utility class");
    }

    public static Double execute() {
        List<Movie> movies = DataUtil.getMovies();

        return movies.stream()
                .map(Movie::getRating)
                .collect(Collectors.toList())
                .stream()
                .reduce(Double::max)
                .orElseThrow(NoSuchElementException::new);
    }


}
