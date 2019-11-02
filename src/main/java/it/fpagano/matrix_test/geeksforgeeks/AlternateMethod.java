package it.fpagano.matrix_test.geeksforgeeks;

public class AlternateMethod {
    public static int R, C;

    private static void diagonalOrder(int[][] arr) {

             /* through this for loop we choose each element
             of first column as starting point and print
             diagonal starting at it. arr[0][0], arr[1][0]
             ....arr[R-1][0] are all starting points */
        for (int k = 0; k < R; k++) {
            System.out.print(arr[k][0] + " ");

            int i = k - 1;    // set row index for next
            // point in diagonal
            int j = 1;       //  set column index for
            // next point in diagonal

            /* Print Diagonally upward */
            while (isValid(i, j)) {
                System.out.print(arr[i][j] + " ");

                i--;
                j++;    // move in upright direction
            }

            System.out.println("");
        }

             /* through this for loop we choose each element
                of last row as starting point (except the
                [0][c-1] it has already been processed in
                previous for loop) and print diagonal
                starting at it. arr[R-1][0], arr[R-1][1]....
                arr[R-1][c-1] are all starting points */

        // Note : we start from k = 1 to C-1;
        for (int k = 1; k < C; k++) {
            System.out.print(arr[R - 1][k] + " ");

            int i = R - 2; // set row index for next
            // point in diagonal
            int j = k + 1; // set column index for
            // next point in diagonal

            /* Print Diagonally upward */
            while (isValid(i, j)) {
                System.out.print(arr[i][j] + " ");

                i--;
                j++; // move in upright direction
            }

            System.out.println("");
        }
    }

    public static boolean isValid(int i, int j) {
        if (i < 0 || i >= R || j >= C || j < 0) {
            return false;
        }
        return true;
    }

    // driver program to test above function
    public static void main(String[] args) {
        int arr[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 },
                { 17, 18, 19, 20 }, };

        R = arr.length;
        C = arr[0].length;

        diagonalOrder(arr);
    }
}

// This code is contributed by Arnav Kr. Mandal.
