package katas;

import model.BoxArt;
import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.stream.*;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();

        String responseUrl = movies.stream()
                .flatMap(movie -> movie.getBoxarts().stream())
                .reduce((a, b) -> a.getWidth() > b.getWidth() ? a : b)
                .get()
                .getUrl();
        return responseUrl;
    }
}
