package it.fpagano.matrix_test.fp.scala

import org.scalatest._
import Matchers._

class MatrixExerciseTest extends FunSuite {

  test("test string") {
    val matrix = List(
      List("1", "A", "5", "7", "B", "N"),
      List("2", "B", "6", "8", "K", "R"),
      List("5", "Q", "N", "3", "B", "1")
    )

    val expectedResult = List("1", "NK3", "A2", "RB", "5B5", "1", "76Q", "B8N")

    val resolver = new MatrixExercise[String]("", _+_)
    val result = resolver.resolve(matrix)

    result.toList should equal(expectedResult)
  }

  test("test ints sum") {
    val expectedResult = List(1, 6, 15, 14, 9)

    val matrix = List(
      List(1, 2, 3),
      List(4, 5, 6),
      List(7, 8, 9)
    )

    val resolver = new MatrixExercise[Int](0, _+_)
    val result = resolver.resolve(matrix)

    result.toList should equal(Iterable(1, 6, 15, 14, 9))
  }

}
