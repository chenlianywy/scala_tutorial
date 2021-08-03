package com.taiping.bigdata.spark.core.chapter07

import scala.collection.immutable

/**
  * @author chenla
  * @create 2021-07-22 2:43 PM
  */
object Test20_Parallel {

  def main(args: Array[String]): Unit = {
    val result: immutable.IndexedSeq[String] = (1 to 100).map(
      x => Thread.currentThread().getName
    )
    println(result)

    val result2 = (1 to 100).par.map(
      x => Thread.currentThread().getName
    )
    println(result2)
  }

}
