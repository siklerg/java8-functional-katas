package katas;

import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.MovieList;
import util.DataUtil;

import java.util.*;
import java.util.stream.*;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        List<Map> selection = movieLists
                .stream()
                .flatMap(m -> m.getVideos().stream()
                        .map(v -> ImmutableMap.of("id", v.getId(), "title", v.getTitle(), "boxart", new BoxArt(150, 200, getBoxArtUrl(v.getBoxarts())))))
//                        .map(v -> ImmutableMap.of("id", v.getId(), "title", v.getTitle(), "boxart",
//                                boxArts -> v.getBoxarts()
//                                        .stream()
//                                        .filter(boxArt -> boxArt.getWidth() == 150)
//                                        .findFirst()
//                                        .get()
//                                        .getUrl()
//                        )))
                .collect(Collectors.toList());
        return selection;
    }

    public static String getBoxArtUrl(List<BoxArt> v){
        Optional<BoxArt> boxArt = v.stream()
                .filter(ba -> ba.getWidth() == 150)
                .findFirst();
        String url = boxArt.isPresent() ? boxArt.get().getUrl() : "";
    return url;
    }
}
