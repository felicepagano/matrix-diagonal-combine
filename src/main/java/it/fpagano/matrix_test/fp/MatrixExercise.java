package it.fpagano.matrix_test.fp;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MatrixExercise {

    public static void main(String[] args) {

        /*
        {"1", "A", "5", "7", "B", "N"},
        {"2", "B", "6", "8", "K", "R"},
        {"5", "Q", "N", "3", "B", "1"}
         */
        List<List<String>> stringMatrix = List.of(
                List.of("1", "A"),
                List.of("2", "B")
        );

        List<List<Integer>> integerMatrixForSum = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );

        List<List<Integer>> integerMatrixForMultiply = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );

        Collection<String> stringResult = resolveMatrix(stringMatrix, " ", joining());
        Collection<Integer> intResultSum = resolveMatrix(integerMatrixForSum, 0, Collectors.summingInt(i -> i));
        Collection<Integer> intResultMultiply = resolveMatrix(integerMatrixForMultiply, 1, Collectors.reducing(1, (o, o2) -> o * o2));

        System.out.println(stringResult);
        System.out.println(intResultSum);
        System.out.println(intResultMultiply);

    }

    private static<T> Collection<T> resolveMatrix(List<List<T>> matrix, T padvalue, Collector<? super T, ?, T> collector) {
        return IntStream.range(0, matrix.size())
                .boxed()
                .map(index -> shiftRight(index, matrix.get(index), padvalue))
                .flatMap(MatrixExercise::zipWithIndex)
                .collect(groupingBy(IndexZipEntry::getKey, mapping(IndexZipEntry::getValue, collector)))
                .values();
    }

    private static <T> Stream<IndexZipEntry<T>> zipWithIndex(List<T> s) {
        return IntStream.range(0, s.size()).boxed()
                .map(i -> IndexZipEntryCompanion.of(i, s.get(i), Predicate.isEqual(0)))
                .filter(IndexZipEntry::isPresent);

    }

    private static <T> List<T> shiftRight(int numberOfCharacter, final List<T> listToShift, final T padValue) {
        List<T> collect = IntStream.range(0, numberOfCharacter).boxed().map(i -> padValue)
                .collect(toList());
        collect.addAll(listToShift);
        return collect;
    }
}
