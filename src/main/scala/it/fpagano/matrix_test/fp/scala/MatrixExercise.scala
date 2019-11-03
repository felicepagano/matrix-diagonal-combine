package it.fpagano.matrix_test.fp.scala

import scala.annotation.tailrec

class MatrixExercise[T](private val unit: T, private val reduce: (Any, Any) => Any) {

  private def fillMatrix(x: Int, value: List[T]): List[Any] = {
    @tailrec
    def fillMatrixRecursive(x: Int, value: List[Any]): List[Any] = x match {
      case 0 => value
      case _ => fillMatrixRecursive(x - 1, None :: value)
    }

    fillMatrixRecursive(x, value)
  }

  def resolve(matrix: List[List[T]]): Iterable[Any] = {
    val shiftedRows = for (
      row <- 0 until matrix.size;
      shiftedRow <- fillMatrix(row, matrix(row)).zipWithIndex
    ) yield shiftedRow

    shiftedRows
      .filter(_._1 match {case None => false; case _ => true})
      .groupMapReduce(_._2)(_._1)(reduce)
      .values
  }
}
