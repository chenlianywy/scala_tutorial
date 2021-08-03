package com.taiping.bigdata.spark.core.rdd.builder

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author chenla
  * @create 2021-07-29 10:56 AM
  */
object Spark03_RDD_File_Pro1 {

  def main(args: Array[String]): Unit = {


    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")

    val sc: SparkContext = new SparkContext(sparkConf)

    val rdd: RDD[String] = sc.textFile("datas/word.txt",2)

    rdd.saveAsTextFile("output")

    println("git test")
    println("git test1")

    sc.stop()

  }

}
