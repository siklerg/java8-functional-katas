package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.*;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        List<Map> responseList = movieLists.stream()
                .flatMap(movieList -> movieList.getVideos().stream())
                .map(movie -> ImmutableMap.of("id", movie.getId(),
                        "title", movie.getTitle(),
                        "time", movie.getInterestingMoments().stream().filter(interestingMoment -> interestingMoment.getType().equals("Middle")).findFirst().get(),
                        "url", movie.getBoxarts().stream().reduce((a, b) -> a.getWidth() < b.getWidth() ? a : b).get().getUrl()))
                .collect(Collectors.toList());

        return responseList;
    }
}
