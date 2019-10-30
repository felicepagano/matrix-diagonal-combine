package it.fpagano.matrix_test.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MatrixDiagonalResolverTest {

  private String[][] s = {
          {"1", "A", "5", "7", "B", "N"},
          {"2", "B", "6", "8", "K", "R"},
          {"5", "Q", "N", "3", "B", "1"}
  };

  private MatrixDiagonalResolver<String> m = new MatrixDiagonalResolver<>(s, String::concat, "");

  private static Stream<Arguments> cases() {
    return Stream.of(
        Arguments.of(0, 0, "1"),
        Arguments.of(0, 1, "A2"),
        Arguments.of(0, 2, "5B5"),
        Arguments.of(1, 5, "RB"),
        Arguments.of(2, 5, "1"));
  }

  /*
  ITERATION USED TO FIND THE GENERIC RULE

  @Test
  @DisplayName("the diagonal (0, 0) must generate just a 1")
  public void diagonal() {
      String result = m.findDiagonal(0, 0, "");
      Assertions.assertEquals("1", result);
  }

  @Test
  @DisplayName("the diagonal (0, 1) must generate A2")
  public void diagonal2() {
      String result = m.findDiagonal(0, 1, "");
      Assertions.assertEquals("A2", result);
  }

  @Test
  @DisplayName("the diagonal (0, 2) must generate 5B5")
  public void diagonal3() {
      String result = m.findDiagonal(0, 2, "");
      Assertions.assertEquals("5B5", result);
  }

  @Test
  @DisplayName("the diagonal (1, 5) must generate RB")
  public void diagonal4() {
      String result = m.findDiagonal(1, 5, "");
      Assertions.assertEquals("RB", result);
  }

  @Test
  @DisplayName("the diagonal (2, 5) must generate 1")
  public void diagonaFullExample() {
      String result = m.findDiagonal(1, 5, "");
      Assertions.assertEquals("RB", result);
  }*/

  @ParameterizedTest
  @MethodSource("cases")
  public void paramTest(int i, int j, String expectedResult) {
    String result = m.findDiagonal(i, j);
    Assertions.assertEquals(expectedResult, result);
  }
}
