package katas;

import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.MovieList;
import util.DataUtil;

import java.util.*;
import java.util.stream.*;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {

    private Kata7() {
        throw new IllegalStateException("Utility class");
    }

    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream()
                .flatMap(movieList -> movieList.getVideos().stream())
                .map(movie -> ImmutableMap.of(
                        "id", movie.getId(),
                        "title", movie.getTitle(),
                        "boxart", getMinBoxArtUrl(movie.getBoxarts())))
                .collect(Collectors.toList());
    }

    public static String getMinBoxArtUrl(List<BoxArt> list){
        return list.stream()
                .reduce((a, b) -> a.getWidth() < b.getWidth() ? a : b)
                .map(BoxArt::getUrl)
                .orElseThrow(NoSuchElementException::new);
    }
}
