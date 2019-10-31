package it.fpagano.matrix_test.fp;

public class IndexZipEntry<T> extends Pair<Integer, T> {

    IndexZipEntry() {
        super();
    }

    IndexZipEntry(Integer key, T value) {
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

