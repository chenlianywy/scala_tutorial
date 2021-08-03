package com.taiping.bigdata.spark.core.wc

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author chenla
  * @create 2021-07-14 11:03 AM
  */
object Spark02_WordCount {

  def main(args: Array[String]): Unit = {

    //  TODO 建立和spark框架的连接
    val sparkConf = new SparkConf().setMaster("local").setAppName("wordCount")

    val sc = new SparkContext(sparkConf)

    val lines: RDD[String] = sc.textFile("datas")

    val words = lines.flatMap(_.split(" "))

    val wordToOne: RDD[(String, Int)] = words.map(
      word => (word, 1)
    )


    val wordGroup: RDD[(String, Iterable[(String, Int)])] = wordToOne.groupBy(t => t._1)

    wordGroup.foreach(println)

    val wordToCount = wordGroup.map {
      case (word, list) => {
        list.reduce(
          (t1,t2) =>{
            (t1._1,t1._2+t2._2)
          }
        )
      }
    }

    val array = wordToCount.collect()
    array.foreach(println)

    //  TODO 关闭连接
    sc.stop()

  }
}
