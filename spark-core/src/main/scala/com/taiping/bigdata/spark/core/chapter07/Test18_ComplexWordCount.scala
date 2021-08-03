package com.taiping.bigdata.spark.core.chapter07

/**
  * @author chenla
  * @create 2021-07-17 11:22 AM
  */
object Test18_ComplexWordCount {

  def main(args: Array[String]): Unit = {

    val stringList: List[(String,Int)] = List(
      ("hello scala from java",2),
      ("hello java",3),
      ("hello spark from scala",1),
      ("hello flink from scala",5),
      ("hello world",2))

    val newStringList = stringList.map(
      kv =>{
        (kv._1.trim+" ") * kv._2

      }
    )

    println(newStringList)
    println("---------------------")

    val tupleList: List[(String, Int)] = newStringList.flatMap(_.split(" "))
      .groupBy(word => word)
      .map(kv => (kv._1, kv._2.size))
      .toList
      .sortBy(_._2)(Ordering[Int].reverse)
      .take(3)

    println(tupleList)


    println("---------------------")

    val preCountList = stringList.flatMap(
      tuple =>{
        val strings = tuple._1.split(" ")
        strings.map(word =>(word,tuple._2))

      }

    )

    println(preCountList)

    val preCountMap: Map[String, List[(String, Int)]] = preCountList.groupBy(_._1)

    println(preCountMap)

    val countMap: Map[String, Int] = preCountMap.mapValues(
      tupleList => tupleList.map(_._2).sum

    )

    val countList: List[(String, Int)] = countMap.toList.sortWith(_._2 > _._2)

    println(countList)



  }

}
