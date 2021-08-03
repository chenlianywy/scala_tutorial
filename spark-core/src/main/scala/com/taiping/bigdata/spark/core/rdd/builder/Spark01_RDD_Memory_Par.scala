package com.taiping.bigdata.spark.core.rdd.builder

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author chenla
  * @create 2021-07-28 4:46 PM
  */
object Spark01_RDD_Memory_Par {

  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")

    val sc: SparkContext = new SparkContext(sparkConf)

    val ints: List[Int] = List(1,2,3,4)

//    val rdd: RDD[Int] = sc.parallelize(ints)

    val rdd: RDD[Int] = sc.makeRDD(ints)

//    rdd.collect().foreach(println)

    rdd.saveAsTextFile("output")

    sc.stop()

  }

}
