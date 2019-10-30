package it.fpagano.matrix_test.tdd;

import java.util.function.BinaryOperator;

public class Matrix<T> {

    private T[][] matrix;

    public Matrix(T[][] matrix) {
        this.matrix = matrix;
    }

    public T[][] getMatrix() {
        return matrix;
    }

    public T diagonal(int i, int j, BinaryOperator<T> combine) {
        if(i == 0 && j ==0 ) {
            return matrix[i][j];
        }
        if(i== 0 && j == 1) {
            return combine.apply(matrix[i][j], matrix[i+1][j-1]);
        }
        return matrix[i][j];
    }
}
