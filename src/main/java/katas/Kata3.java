package katas;

import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/*
    Goal: Use map() and flatMap() to project and flatten the movieLists into an array of video ids (flatMap(c -> c.stream()))
    DataSource: DataUtil.getMovieLists()
    Output: List of Integers
*/
public class Kata3 {

    private Kata3() {
        throw new IllegalStateException("Utility class");
    }

    public static List<Integer> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        return movieLists.stream()
                .flatMap(getMovieIds())
                .collect(Collectors.toList());
    }

    private static Function<MovieList, Stream<Integer>> getMovieIds() {
        return m -> m.getVideos()
                .stream()
                .map(Movie::getId);
    }
}
