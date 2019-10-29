package it.fpagano.test;

public class Main {

    public static void main(String[] args) {

        int n = 6;
        int m = 3;
        String [][] matrix = {
            {"1", "A", "5", "7", "B", "N"},
            {"2", "B", "6", "8", "K", "R"},
            {"5", "Q", "N", "3", "B", "1"}
        };

        String [][] result = new String[m][n+m];

        for (int i = 0; i < matrix.length; i++) {
            fillCells(result, i);
            System.arraycopy(matrix[i], 0, result[i], i, matrix[i].length);
        }

        for(int j = 0; j < n+m; j++) {
            for(int i = 0; i < m; i++) {
                if(result[i][j] != null) {
                    System.out.print(result[i][j]);
                }
            }
            System.out.println();
        }
    }

    private static void fillCells(String[][] result, int i) {
        for(int j = 0; j < i; j++) {
            result[i][j] = " ";
        }
    }
}
