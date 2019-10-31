package it.fpagano.matrix_test;

public class IndexZipEntry<T> extends Pair<Integer, T> {

    public IndexZipEntry() {
        super();
    }

    public IndexZipEntry(Integer key, T value) {
        super(key, value);
    }

    public boolean isPresent() {
        return true;
    }

    static class EmptyIndexEntry<T> extends IndexZipEntry<T> {

        @Override
        public boolean isPresent() {
            return false;
        }
    }
}

