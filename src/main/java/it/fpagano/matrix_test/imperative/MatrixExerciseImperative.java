package it.fpagano.matrix_test.imperative;

public class MatrixExerciseImperative {

  public static void main(String[] args) {

    String[][] matrix = {
      {"1", "A"},
      {"2", "B"}
    };

    int m = matrix.length;
    int n = matrix[m-1].length;

    String[][] result = new String[m][n + m];

    for (int i = 0; i < matrix.length; i++) {
      shiftCellsRight(result, i);
      System.arraycopy(matrix[i], 0, result[i], i, matrix[i].length);
    }

    for (int j = 0; j < n + m; j++) {
      for (int i = 0; i < m; i++) {
        if (result[i][j] != null && !result[i][j].isBlank()) {
          System.out.print(result[i][j]);
        }
      }
      System.out.println("");
    }
  }

  private static void shiftCellsRight(String[][] result, int i) {
    for (int j = 0; j < i; j++) {
      result[i][j] = " ";
    }
  }
}
