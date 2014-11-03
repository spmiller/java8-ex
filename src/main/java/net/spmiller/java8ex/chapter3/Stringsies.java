package net.spmiller.java8ex.chapter3;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Stringsies {

    public int countLowercase(String string) {
        return (int) string.chars().filter(Character::isLowerCase).count();
    }

    public Optional<String> mostLower(List<String> strings) {
        return strings.stream().min(Comparator.comparing(this::countLowercase));
    }
}
