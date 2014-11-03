package net.spmiller.java8ex.chapter3;

import com.insightfullogic.java8.examples.chapter1.Artist;
import com.insightfullogic.java8.examples.chapter1.SampleData;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class IterationTest {
    private Iteration iteration = new Iteration();

    @Test
    public void shouldAddUpEmptyIterable() throws Exception {
        assertThat(iteration.totalMembers(Collections.<Artist>emptyList()), is(0));
    }

    @Test
    public void shouldAddUpOneArtist() throws Exception {
        assertThat(iteration.totalMembers(Collections.singletonList(SampleData.theBeatles)), is(4));
    }

    @Test
    public void shouldAddUpMultipleArtists() throws Exception {
        assertThat(iteration.totalMembers(Arrays.asList(SampleData.theBeatles, SampleData.theBeatles)), is(8));
    }

}