package it.fpagano.matrix_test.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MatrixTest {

    @Test
    @DisplayName("the diagonal (0, 0) must generate just a 1")
    public void diagonal() {
        String[][] matrix = {
                {"1", "A", "5", "7", "B", "N"},
                {"2", "B", "6", "8", "K", "R"},
                {"5", "Q", "N", "3", "B", "1"}
        };
        Matrix<String> m = new Matrix<>(matrix);
        String result = m.diagonal(0, 0, String::concat);
        Assertions.assertEquals("1", result);
    }

    @Test
    @DisplayName("the diagonal (0, 1) must generate A2")
    public void diagona2l() {
        String[][] matrix = {
                {"1", "A", "5", "7", "B", "N"},
                {"2", "B", "6", "8", "K", "R"},
                {"5", "Q", "N", "3", "B", "1"}
        };
        Matrix<String> m = new Matrix<>(matrix);
        String result = m.diagonal(0, 1, String::concat);
        Assertions.assertEquals("A2", result);
    }


}