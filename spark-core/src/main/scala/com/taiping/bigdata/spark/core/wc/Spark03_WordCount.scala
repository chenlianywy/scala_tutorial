package com.taiping.bigdata.spark.core.wc

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author chenla
  * @create 2021-07-14 11:03 AM
  */
object Spark03_WordCount {

  def main(args: Array[String]): Unit = {

    //  TODO 建立和spark框架的连接
    val sparkConf = new SparkConf().setMaster("local").setAppName("wordCount")

    val sc = new SparkContext(sparkConf)

    val lines: RDD[String] = sc.textFile("datas")

    val words = lines.flatMap(_.split(" "))

    val wordToOne: RDD[(String, Int)] = words.map(
      word => (word, 1)
    )


    val wordToCount = wordToOne.reduceByKey(_+_)

    val array = wordToCount.collect()
    array.foreach(println)

    //  TODO 关闭连接
    sc.stop()

  }
}
