package net.spmiller.java8ex.chapter3;

import com.insightfullogic.java8.examples.chapter1.Album;
import com.insightfullogic.java8.examples.chapter1.Artist;
import com.insightfullogic.java8.examples.chapter1.SampleData;
import org.junit.Test;

import java.util.Collections;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CommonOperationsTest {

    private final CommonOperations operations = new CommonOperations();

    @Test
    public void shouldAddUpEmptyStream() throws Exception {
        assertThat(operations.addUp(Stream.<Integer>empty()), is(0));
    }

    @Test
    public void shouldAddUpSingleStream() throws Exception {
        assertThat(operations.addUp(Stream.of(1)), is(1));
    }

    @Test
    public void shouldAddUpMultipleElementsInStream() throws Exception {
        assertThat(operations.addUp(Stream.of(1, 2, 3)), is(6));
    }


    @Test
    public void shouldSummariseEmptyStream() throws Exception {
        assertThat(operations.artistNationalities(Stream.<Artist>empty()), is(Collections.emptyList()));
    }

    @Test
    public void shouldSummariseOneArtist() throws Exception {
        assertThat(operations.artistNationalities(Stream.of(SampleData.georgeHarrison)), is(Collections.singletonList("George Harrison -- UK")));
    }

    @Test
    public void shouldSummariseMultipleArtists() throws Exception {
        assertThat(operations.artistNationalities(Stream.of(SampleData.johnColtrane, SampleData.georgeHarrison)), containsInAnyOrder("George Harrison -- UK", "John Coltrane -- US"));
    }



    @Test
    public void shouldFindNoAlbumsFromEmpty() throws Exception {
        assertThat(operations.findUnderThreeTracks(Stream.<Album>empty()), is(Collections.emptyList()));
    }

    @Test
    public void shouldFindShortAlbums() throws Exception {
        assertThat(operations.findUnderThreeTracks(Stream.of(SampleData.sampleShortAlbum)), is(Collections.singletonList(SampleData.sampleShortAlbum)));
    }

    @Test
    public void shouldIgnoreLongAlbums() throws Exception {
        assertThat(operations.findUnderThreeTracks(Stream.of(SampleData.manyTrackAlbum)), is(Collections.emptyList()));
    }

    @Test
    public void shouldFindAlbumsWithAMixtureOfLengths() throws Exception {
        assertThat(operations.findUnderThreeTracks(Stream.of(SampleData.sampleShortAlbum, SampleData.manyTrackAlbum)), is(Collections.singletonList(SampleData.sampleShortAlbum)));
    }
}