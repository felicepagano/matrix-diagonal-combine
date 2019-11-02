package it.fpagano.matrix_test.fp.scala

import scala.annotation.tailrec

class MatrixExercise[T](private val unit: T, private val reduce: (T, T) => T) {

  private def fillMatrix(x: Int, value: List[T]): List[Option[T]] = {
    @tailrec
    def fillMatrixRecursive(x: Int, value: List[Option[T]]): List[Option[T]] = x match {
      case 0 => value
      case _ => fillMatrixRecursive(x - 1, Option.empty :: value)
    }

    fillMatrixRecursive(x, value.map(Option(_)))
  }

  def resolve(matrix: List[List[T]]): Iterable[T] = {
    val shiftedRows = for (
      row <- 0 until matrix.size;
      shiftedRow <- fillMatrix(row, matrix(row)).zipWithIndex
    ) yield shiftedRow

    shiftedRows
      .filter(_._1.nonEmpty)
      .groupMapReduce(_._2)(_._1.get)(reduce)
      .values
  }
}
