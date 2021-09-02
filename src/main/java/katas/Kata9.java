package katas;

import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.InterestingMoment;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.*;
import java.util.stream.*;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {

    private Kata9() {
        throw new IllegalStateException("Utility class");
    }

    public static List<Map<String, Object>> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        List<Map<String, Object>> responseList = movieLists.stream()
                .flatMap(movieList -> movieList.getVideos().stream())
                .map(movie -> ImmutableMap.of("id", movie.getId(),
                        "title", movie.getTitle(),
                        "time", getMiddleInterestingMoment(movie),
                        "url", getMinBoxartUrl(movie)))
                .collect(Collectors.toList());

        return responseList;
    }

    private static InterestingMoment getMiddleInterestingMoment(Movie movie) {
        Optional<InterestingMoment> interestingMoment =  movie.getInterestingMoments().stream()
                .filter(im -> im.getType().equals("Middle"))
                .findFirst();
        return interestingMoment.orElseThrow(NoSuchElementException::new);
    }

    private static String getMinBoxartUrl(Movie movie){
        BoxArt boxArt = movie.getBoxarts().stream()
                .reduce((a, b) -> a.getWidth() < b.getWidth() ? a : b)
                .orElseThrow(NoSuchElementException::new);
        return boxArt.getUrl();
    }
}
