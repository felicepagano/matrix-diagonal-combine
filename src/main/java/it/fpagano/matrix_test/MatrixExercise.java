package it.fpagano.matrix_test;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;

import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MatrixExercise {

    public static void main(String[] args) {

        /*
        {"1", "A", "5", "7", "B", "N"},
        {"2", "B", "6", "8", "K", "R"},
        {"5", "Q", "N", "3", "B", "1"}
         */
        List<String> matrix = List.of("1A", "2B");

        Collection<String> values = IntStream.range(0, matrix.size()).boxed()
                .map(index -> shiftRigth(index, matrix.get(index), " "))
                .flatMap(MatrixExercise::zipWithIndex)
                .collect(groupingBy(IndexStringZipEntry::getKey, mapping(IndexStringZipEntry::getValue, joining())))
                .values();

        System.out.println("values = " + values);
    }

    private static Stream<IndexStringZipEntry> zipWithIndex(String s) {
        String[] split = s.split("", -1);
        return IntStream.range(0, split.length).boxed()
                .map(i -> IndexStringZipEntry.of(i, split[i]))
                .filter(IndexStringZipEntry::isPresent);

    }

    private static String shiftRigth(int numberOfCharacter, final String stringToShift, final String padString) {
        return IntStream.range(0, numberOfCharacter).boxed()
                .map(i -> padString)
                .collect(joining()) + stringToShift;
    }
}
