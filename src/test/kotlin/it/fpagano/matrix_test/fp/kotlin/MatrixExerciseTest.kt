package it.fpagano.matrix_test.fp.kotlin

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class MatrixExerciseTest {

    @Test
    fun findStrings() {
        val matrix = listOf(
                listOf("1", "A", "5", "7", "B", "N"),
                listOf("2", "B", "6", "8", "K", "R"),
                listOf("5", "Q", "N", "3", "B", "1")
        )

        val expectedResult = listOf("1", "A2", "5B5", "76Q", "B8N", "NK3", "RB", "1")

        val matrixStringResolver = MatrixExercise("", String::plus)
        val result = matrixStringResolver.find(matrix)

        Assertions.assertEquals(expectedResult, result)
        //assertThat<Collection<String>>(result, contains<Any>(*expectedResult.toTypedArray()))

    }

    @Test
    fun findIntsSum() {
        val matrix = listOf(
                listOf(1, 2),
                listOf(3, 4),
                listOf(5, 6)
        )

        val expectedResult = listOf(1, 5, 9, 6)

        val matrixIntSumResolver = MatrixExercise(0, Int::plus)
        val result = matrixIntSumResolver.find(matrix)

        Assertions.assertEquals(expectedResult, result)

    }
}