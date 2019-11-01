package it.fpagano.matrix_test.fp;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import it.fpagano.matrix_test.fp.datastructure.IndexZipEntries;
import it.fpagano.matrix_test.fp.datastructure.IndexZipEntry;

public class MatrixExercise<T> {

    private final Collector<? super T, ?, T> collector;

    public MatrixExercise(Collector<? super T, ?, T> collector) {
        this.collector = collector;
    }

    Collection<T> resolveMatrix(List<List<T>> matrix) {
        return IntStream.range(0, matrix.size())
                .boxed()
                .map(index -> shiftRight(index, matrix.get(index)))
                .flatMap(this::zipWithIndex)
                .collect(groupingBy(IndexZipEntry::getKey, mapping(IndexZipEntry::getValue, collector)))
                .values();
    }

    private Stream<IndexZipEntry<T>> zipWithIndex(List<T> s) {
        return IntStream.range(0, s.size())
                .boxed()
                .map(i -> IndexZipEntries.of(i, s.get(i)))
                .filter(IndexZipEntry::isPresent);

    }

    private List<T> shiftRight(int numberOfCharacter, final List<T> listToShift) {
        List<T> collect = IntStream.range(0, numberOfCharacter)
                .boxed()
                .map(i -> (T)null)
                .collect(toList());
        collect.addAll(listToShift);
        return collect;
    }
}
