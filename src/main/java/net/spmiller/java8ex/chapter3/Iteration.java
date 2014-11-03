package net.spmiller.java8ex.chapter3;

import com.insightfullogic.java8.examples.chapter1.Artist;

import java.util.stream.StreamSupport;

public class Iteration {
    public int totalMembers(Iterable<Artist> artists) {
        return (int) StreamSupport.stream(artists.spliterator(), false).flatMap(Artist::getMembers).count();
    }
}
