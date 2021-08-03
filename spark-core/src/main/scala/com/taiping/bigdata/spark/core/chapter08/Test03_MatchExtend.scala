package com.taiping.bigdata.spark.core.chapter08

/**
  * @author chenla
  * @create 2021-07-22 5:01 PM
  */
object Test03_MatchExtend {

  def main(args: Array[String]): Unit = {
    //1.在变量声明时匹配
    val (x,y) = (10,"hello")
    println(s"x:$x, y:$y")


    val List(first,second,_*) = List(23,3,15,9,65)

    println(s"first:$first, second:$second")

    val fir :: sec :: rest = List(23,3,15,9,65)
    println(s"first:$first, second:$second,rest:$rest")


    //2.for推到式的模式匹配
    val list:List[(String,Int)] = List(("a",12),("b",14),("c",16),("a",17))

    //2.1 原本的遍历方式
    for(elem <- list){
      println(elem._1 + "：" + elem._2)
    }

    //2.2 将List的元素直接定义为元祖
    for((word,count) <- list){
      println(word +": " +count)
    }

    println("---------------")

    //2.3可以不考虑某个位置的变量，只遍历key或value
    for((word,_) <- list)
      println(word)

    println("---------------")
    //2.4可以指定某个位置的值必须是多少
    for(("a",count) <- list)
      println(count)
  }


}
