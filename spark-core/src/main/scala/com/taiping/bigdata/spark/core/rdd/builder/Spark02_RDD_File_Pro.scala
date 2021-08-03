package com.taiping.bigdata.spark.core.rdd.builder

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author chenla
  * @create 2021-07-29 10:56 AM
  */
object Spark02_RDD_File_Pro {

  def main(args: Array[String]): Unit = {


    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")

    val sc: SparkContext = new SparkContext(sparkConf)

//    val rdd: RDD[String] = sc.textFile("datas/1.txt")

    val rdd: RDD[String] = sc.textFile("datas/1.txt",3)


    rdd.saveAsTextFile("output")

    sc.stop()

  }

}
