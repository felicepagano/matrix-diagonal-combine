package it.fpagano.matrix_test.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class MatrixDiagonalResolver<T> {

  private final T[][] matrix;
  private final BinaryOperator<T> combine;
  private final T unit;

  public MatrixDiagonalResolver(T[][] matrix, BinaryOperator<T> combine, T unit) {
    this.matrix = matrix;
    this.combine = combine;
    this.unit = unit;
  }

  public static void main(String[] args) {

    String[][] s = {
      {"1", "A", "5", "7", "B", "N"},
      {"2", "B", "6", "8", "K", "R"},
      {"5", "Q", "N", "3", "B", "1"}
    };

    Integer[][] is = {
      {1, 2, 3, 4, 5},
      {1, 2, 3, 4, 5},
      {1, 2, 3, 4, 5}
    };

    MatrixDiagonalResolver<String> exercise = new MatrixDiagonalResolver<>(s, String::concat, "");
    exercise.findAllDiagonal();

    MatrixDiagonalResolver<Integer> exerciseIntegerSum =
        new MatrixDiagonalResolver<>(is, Integer::sum, 0);
    exerciseIntegerSum.findAllDiagonal();

    MatrixDiagonalResolver<Integer> exerciseIntegerMultiplier =
        new MatrixDiagonalResolver<>(is, (a, b) -> a * b, 1);
    exerciseIntegerMultiplier.findAllDiagonal();
  }

  /*
      ITERATION USED TO FIND THE GENERIC RULE

      public T findDiagonal(int i, int j, BinaryOperator<T> combine) {
          if(i == 0 && j ==0 ) {
              return matrix[i][j];
          }
          if(i== 0 && j == 1) {
              return combine.apply(matrix[i][j], matrix[i+1][j-1]);
          }
          if(i == 0 && j == 2) {
              return combine.andThen(t -> combine.apply(t, matrix[i+2][j-2])).apply(matrix[i][j], matrix[i+1][j-1]);
          }
          return matrix[i][j];
      }
  */

  public void findAllDiagonal() {
    List<T> results = new ArrayList<>();
    int j = 0;
    for (; j < matrix[0].length; j++) {
      results.add(findDiagonal(0, j));
    }

    for (int i = 1; i < matrix.length; i++) {
      results.add(findDiagonal(i, j - 1));
    }

    System.out.println(results);
  }

  public T findDiagonal(int i, int j) {
      return findDiagonalRecursive(i, j, this.unit);
  }

  private T findDiagonalRecursive(int i, int j, T unit) {
    if (j >= 0 && i < matrix.length) {
      // System.out.printf("(%s, %s)", i, j);
      return combine.apply(unit, findDiagonalRecursive(i + 1, j - 1, matrix[i][j]));
    }
    // System.out.println();
    return unit;
  }

}
