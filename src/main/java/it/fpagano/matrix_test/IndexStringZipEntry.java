package it.fpagano.matrix_test;

import java.util.function.Predicate;

public class IndexStringZipEntry<T> extends Pair<Integer, T> {

    private static final IndexStringZipEntry EMPTY = new EmptyIndexStringEntry();

    public IndexStringZipEntry() {
        super();
    }

    public IndexStringZipEntry(Integer key, T value) {
        super(key, value);
    }

    public static <T> IndexStringZipEntry<T> of(Integer key, T value, Predicate<T> isBlank) {
        if(isBlank.test(value)) {
            return empty();
        } else {
            return new IndexStringZipEntry<T>(key, value);
        }
    }

    public static IndexStringZipEntry empty() {
        return EMPTY;
    }

    public boolean isPresent() {
        return true;
    }

    private static class EmptyIndexStringEntry extends IndexStringZipEntry {

        @Override
        public boolean isPresent() {
            return false;
        }
    }
}

