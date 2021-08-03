package com.taiping.bigdata.spark.core.rdd.builder

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
  * @author chenla
  * @create 2021-07-29 10:56 AM
  */
object Spark02_RDD_File1 {

  def main(args: Array[String]): Unit = {


    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")

    val sc: SparkContext = new SparkContext(sparkConf)

    val rdd: RDD[(String, String)] = sc.wholeTextFiles("datas")

    rdd.collect().foreach(println)

    sc.stop()

  }

}
