package it.fpagano.matrix_test;

public class IndexStringZipEntryCompanion {

    static final IndexStringZipEntry EMPTY = new IndexStringZipEntry.EmptyIndexStringEntry();

    private IndexStringZipEntryCompanion() {
    }

    public static IndexStringZipEntry of(Integer key, String value) {
        if (value.isBlank()) {
            return empty();
        } else {
            return new IndexStringZipEntry(key, value);
        }
    }

    public static IndexStringZipEntry empty() {
        return IndexStringZipEntryCompanion.EMPTY;
    }
}
