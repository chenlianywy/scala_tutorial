package com.taiping.bigdata.spark.core.chapter09plus

/**
  * @author chenla
  * @create 2021-07-26 4:11 PM
  */
object Test01_Exception {

  def main(args: Array[String]): Unit = {

    try{
      val i = 10 /0

    }catch {
      case e :ArithmeticException =>{
        println("发生了算术异常")
      }
      case e:Exception =>{
        println("发生了一般异常")
      }

    }finally {
      println("处理结束")
    }

  }

}
