package net.spmiller.java8ex.chapter3;

import com.insightfullogic.java8.examples.chapter1.Album;
import com.insightfullogic.java8.examples.chapter1.Artist;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommonOperations {

    public int addUp(Stream<Integer> numbers) {
        return numbers.reduce(Integer::sum).orElse(0);
    }

    public List<String> artistNationalities(Stream<Artist> artists) {
        return artists.map((a) -> String.format("%s -- %s", a.getName(), a.getNationality())).collect(Collectors.toList());
    }

    public List<Album> findUnderThreeTracks(Stream<Album> albums) {
        return albums.filter((a) -> a.getTracks().count() < 4).collect(Collectors.toList());
    }
}
