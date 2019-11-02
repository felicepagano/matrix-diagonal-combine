package it.fpagano.matrix_test.fp.kotlin

import java.util.Optional

class MatrixExercise<T>(private val unit: T, private val operation: (acc: T, T) -> T) {

    fun find(matrix: List<List<T>>) = generateSequence(0) { it + 1 }.take(matrix.size).toList()
            .flatMap { shiftRight(it, matrix[it].map { e -> Optional.of(e) }).withIndex() }
            .filter { it.value.isPresent }
            .groupBy({ it.index }, { it.value.get() })
            .values.map { it.fold(unit, operation) }

    private tailrec fun <T> shiftRight(n: Int, list: List<Optional<T>>): List<Optional<T>> = when (n) {
        0 -> list
        else -> shiftRight(n - 1, Optional.empty<T>() + list)
    }

    operator fun <T> Optional<T>.plus(xs: List<Optional<T>>): List<Optional<T>> = listOf(this) + xs
}