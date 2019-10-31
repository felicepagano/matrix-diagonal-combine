package it.fpagano.matrix_test;

import java.util.function.Predicate;

public class IndexZipEntryCompanion {

    private static final IndexZipEntry<?> EMPTY = new IndexZipEntry.EmptyIndexEntry<>();

    private IndexZipEntryCompanion() {
    }

    public static <T> IndexZipEntry<T> of(Integer key, T value, Predicate<T> isBlank) {
        if(isBlank.test(value)) {
            return empty();
        } else {
            return new IndexZipEntry<>(key, value);
        }
    }

    private static<T> IndexZipEntry<T> empty() {
        return (IndexZipEntry<T>) EMPTY;
    }
}
