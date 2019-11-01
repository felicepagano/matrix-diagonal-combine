package it.fpagano.matrix_test.fp.datastructure;

public class IndexZipEntries {

    private static final IndexZipEntry<?> EMPTY = new IndexZipEntry.EmptyIndexEntry<>();

    private IndexZipEntries() {
    }

    public static <T> IndexZipEntry<T> of(Integer key, T value) {
        if(value == null) {
            return empty();
        } else {
            return new IndexZipEntry<>(key, value);
        }
    }

    private static<T> IndexZipEntry<T> empty() {
        return (IndexZipEntry<T>) EMPTY;
    }
}
