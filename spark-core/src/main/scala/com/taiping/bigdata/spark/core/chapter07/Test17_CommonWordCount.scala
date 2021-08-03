package com.taiping.bigdata.spark.core.chapter07

/**
  * @author chenla
  * @create 2021-07-17 11:08 AM
  */
object Test17_CommonWordCount {

  def main(args: Array[String]): Unit = {

    val stringList = List(
      "hello scala",
      "hello java",
      "hello spark",
      "hello world")

//    val list: List[Array[String]] = stringList.map(_.split(" "))
//    val flattenList: List[String] = list.flatten
//    println(flattenList)
    val wordList = stringList.flatMap(_.split(" "))
    println(wordList)

    val groupMap: Map[String, List[String]] = wordList.groupBy(word => word)
    println(groupMap)

    val countMap: Map[String, Int] = groupMap.map(kv => (kv._1,kv._2.length))

    println(countMap)

    val list: List[(String, Int)] = countMap.toList.sortWith(_._2 > _._2).take(3)
    println(list)


  }

}
