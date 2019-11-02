package it.fpagano.matrix_test.geeksforgeeks;

public class Easy {

    private static int M[][] = {
            { 1, 2, 3, 4 },
            { 5, 6, 7, 8 },
            { 9, 10, 11, 12 },
            { 13, 14, 15, 16 },
            { 17, 18, 19, 20 }, };

    private static int R = 5;
    private static int C = 4;

    public static void main(String[] args) {

        //step 1 : Finish first half
        for (int row = 0; row < R; ++row) {
            int r = row; // every iteration row increases (top--> down)
            int c = 0;   // column start from always 0
            printFrom(r, c);
        }

        //step : 2 Finish second half. Start from bottom row second column
        for (int col = 1; col < C; ++col) {
            int r = R - 1; // row remains at last position only
            int c = col;   // column is increases at every iteration.

            printFrom(r, c);
        }


    }

    private static void printFrom(int r, int c) {
        while (isValid(r, c)) {
            System.out.println(M[r][c]);
            --r;  // row goes from bottom to top
            ++c; // this also goes from bottom to top
        }
    }

    private static boolean isValid(int i, int j) {
        if (i < 0 || i >= R || j >= C || j < 0) {
            return false;
        }
        return true;
    }

}
