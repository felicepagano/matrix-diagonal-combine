package it.fpagano.matrix_test.fp;

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

  K getKey() {
    return key;
  }

  V getValue() {
    return value;
  }
}
