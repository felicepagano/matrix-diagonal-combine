package it.fpagano.test;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MatrixExercise {

    private static final Predicate<Pair<Integer, String>> NOT_EMPTY = not(pair -> pair.getValue().isBlank());

    public static void main(String[] args) {

        List<String> matrix = List.of("1A", "2B");

        Collection<String> values = IntStream.range(0, matrix.size()).boxed()
                .map(index -> padLeft(index, matrix.get(index), " "))
                .flatMap(MatrixExercise::zipStringWithIndex)
                .collect(groupingBy(Pair::getKey, mapping(Pair::getValue, joining())))
                .values();

        System.out.println("values = " + values);
    }

    private static Stream<Pair<Integer, String>> zipStringWithIndex(String s) {
        String[] split = s.split("", -1);
        return IntStream.range(0, split.length).boxed()
                .map(i -> new Pair<>(i, split[i]))
                .filter(NOT_EMPTY);

    }

    private static String padLeft(int numberOfCharacter, final String stringToPad, final String padString) {
        return IntStream.range(0, numberOfCharacter).boxed()
                .map(i -> padString)
                .collect(joining()) + stringToPad;
    }
}
