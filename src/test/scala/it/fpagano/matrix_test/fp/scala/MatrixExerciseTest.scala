package it.fpagano.matrix_test.fp.scala

import org.scalatest.FunSuite

class MatrixExerciseTest extends FunSuite {

  test("test string") {
    val matrix = List(
      List("1", "A", "5", "7", "B", "N"),
      List("2", "B", "6", "8", "K", "R"),
      List("5", "Q", "N", "3", "B", "1")
    )

    val resolver = new MatrixExercise[String]("", _+_)
    val result = resolver.resolveMatrix(matrix)
  }

  test("test int ") {
    val matrix = List(
      List(1, 2, 3),
      List(4, 5, 6),
      List(7, 8, 9)
    )

    val resolver = new MatrixExercise[Int](0, _+_)
    val result = resolver.resolveMatrix(matrix)
    println(result)
  }

}
