package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.BoxArt;
import model.Movie;
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
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        List<Map> responseList = movieLists.stream()
                .flatMap(movieList -> movieList.getVideos().stream())
                .map(movie -> ImmutableMap.of("id", movie.getId(), "title", movie.getTitle(), "boxart", movie.getBoxarts().stream()
                        .reduce((a, b) -> a.getWidth() < b.getWidth() ? a : b)
                        .get().getUrl()))
                .collect(Collectors.toList());

//        List<Map> list = movieLists.stream()
//                .flatMap(movieList -> movieList.getVideos().stream())
//                .map(movie -> ImmutableMap.of("id", movie.getId(), "title", movie.getTitle(), "boxart", getMinBoxArtUrl(movie.getBoxarts())))
//                .collect(Collectors.toList());
        return responseList;
    }

//    public static BoxArt getMinBoxArtUrl(List<BoxArt> list){
//        BoxArt boxArt = list.stream()
//                .reduce((a, b) -> a.getWidth() < b.getWidth() ? a : b)
//                .get();
//        return boxArt;
//    }
}
