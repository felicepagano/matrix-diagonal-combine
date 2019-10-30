package it.fpagano.matrix_test;

public class IndexStringZipEntry extends Pair<Integer, String> {

    private static final IndexStringZipEntry EMPTY = new EmptyIndexStringEntry();

    public IndexStringZipEntry() {
        super();
    }

    public IndexStringZipEntry(Integer key, String value) {
        super(key, value);
    }

    public static IndexStringZipEntry of(Integer key, String value) {
        if(value.isBlank()) {
            return empty();
        } else {
            return new IndexStringZipEntry(key, value);
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

