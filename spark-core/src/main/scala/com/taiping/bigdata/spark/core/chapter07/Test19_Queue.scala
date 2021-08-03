package com.taiping.bigdata.spark.core.chapter07

import scala.collection.mutable

/**
  * @author chenla
  * @create 2021-07-20 1:53 PM
  */
object Test19_Queue {

  def main(args: Array[String]): Unit = {

    val queue: mutable.Queue[String] = new mutable.Queue[String]()

    queue.enqueue("a","b","c")

    println(queue)
    println(queue.dequeue())

    println(queue)
    println(queue.dequeue())

    println(queue)
    println(queue.dequeue())

    queue.enqueue("d","e")
    println(queue)
    println(queue.dequeue())


  }


}
