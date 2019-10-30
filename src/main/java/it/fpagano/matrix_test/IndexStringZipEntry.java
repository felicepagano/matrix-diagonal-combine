package it.fpagano.matrix_test;

public class IndexStringZipEntry extends Pair<Integer, String> {

  public IndexStringZipEntry() {
    super();
  }

  public IndexStringZipEntry(Integer key, String value) {
    super(key, value);
  }

  public boolean isPresent() {
    return true;
  }

  static class EmptyIndexStringEntry extends IndexStringZipEntry {

    @Override
    public boolean isPresent() {
      return false;
    }
  }
}
