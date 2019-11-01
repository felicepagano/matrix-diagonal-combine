package it.fpagano.matrix_test.fp.datastructure;

class Pair<K, V> {

  private K key;
  private V value;

  Pair() {}

  Pair(K key, V value) {
    this.key = key;
    this.value = value;
  }

  static <K, V> Pair<K, V> of(K key, V value) {
    return new Pair<>(key, value);
  }

  public K getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }
}
