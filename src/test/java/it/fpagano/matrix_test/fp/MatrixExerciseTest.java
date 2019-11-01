package it.fpagano.matrix_test.fp;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summingInt;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;

import org.junit.jupiter.api.Test;

class MatrixExerciseTest {

    @Test
    void resolveStringMatrix() {

        final Collector<CharSequence, ?, String> strConcat = joining();

        List<String> expectedResult = List.of("1", "A2", "5B5", "76Q", "B8N", "NK3", "RB", "1");

        List<List<String>> stringMatrix = List.of(
                List.of("1", "A", "5", "7", "B", "N"),
                List.of("2", "B", "6", "8", "K", "R"),
                List.of("5", "Q", "N", "3", "B", "1")
        );

        MatrixExercise<String> matrixStringResolver = new MatrixExercise<>(strConcat);
        Collection<String> result = matrixStringResolver.resolveMatrix(stringMatrix);

        assertThat(result, contains(expectedResult.toArray()));
    }

    @Test
    void resolveIntegerSumMatrix() {
        final Collector<Integer, ?, Integer> sum = summingInt(i -> i);

        List<Integer> expectedResult = List.of(1, 5, 4);

        List<List<Integer>> intMatrix = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );

        MatrixExercise<Integer> matrixIntegerSumResolver = new MatrixExercise<>(sum);
        Collection<Integer> result = matrixIntegerSumResolver.resolveMatrix(intMatrix);

        assertThat(result, contains(expectedResult.toArray()));

    }

    @Test
    void resolveIntegerMultiplyMatrix() {
        final Collector<Integer, ?, Integer> multiply = reducing(1, (i, j) -> i * j);

        List<Integer> expectedResult = List.of(1, 6, 4);

        List<List<Integer>> intMatrix = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );

        MatrixExercise<Integer> matrixIntegerMultiplyResolver = new MatrixExercise<>(multiply);
        Collection<Integer> result = matrixIntegerMultiplyResolver.resolveMatrix(intMatrix);

        assertThat(result, contains(expectedResult.toArray()));

    }
}