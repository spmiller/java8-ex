package net.spmiller.java8ex.chapter3;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StringsiesTest {
    private Stringsies stringsies = new Stringsies();

    @Test
    public void countShouldWorkForEmptyString() throws Exception {
        assertThat(stringsies.countLowercase(""), is(0));
    }

    @Test
    public void countShouldWorkForAllCapsString() throws Exception {
        assertThat(stringsies.countLowercase("STUART"), is(0));
    }

    @Test
    public void countShouldWorkForAllLowercaseString() throws Exception {
        assertThat(stringsies.countLowercase("stuart"), is(6));
    }

    @Test
    public void countShouldWorkForMixedCaseString() throws Exception {
        assertThat(stringsies.countLowercase("StUaRt"), is(3));
    }



    @Test
    public void findShouldReturnNoneForEmptyList() throws Exception {
        assertThat(stringsies.mostLower(Collections.emptyList()), is(Optional.empty()));
    }

    @Test
    public void findShouldReturnSingleton() throws Exception {
        assertThat(stringsies.mostLower(Collections.singletonList("STUART")), is(Optional.of("STUART")));
    }

    @Test
    public void findShouldReturnLeastValue() throws Exception {
        assertThat(stringsies.mostLower(Arrays.asList("sTuArT", "stuart", "STUARt")), is(Optional.of("STUARt")));
    }

}