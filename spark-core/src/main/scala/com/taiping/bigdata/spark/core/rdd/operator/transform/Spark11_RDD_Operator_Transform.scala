package com.taiping.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author chenla
  * @create 2021-08-05 5:00 PM
  */
object Spark11_RDD_Operator_Transform {

  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")

    val sc: SparkContext = new SparkContext(sparkConf)

    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4,5,6),3)

//    val newRDD: RDD[Int] = rdd.coalesce(2)
//    val newRDD: RDD[Int] = rdd.coalesce(3)
//    val newRDD: RDD[Int] = rdd.coalesce(3,true)
    val newRDD: RDD[Int] = rdd.coalesce(2,true)

    val sortRDD: RDD[Int] = newRDD.sortBy(num=>num)

    sortRDD.saveAsTextFile("output")

    sc.stop()


  }

}
