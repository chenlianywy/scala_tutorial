package com.taiping.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author chenla
  * @create 2021-08-05 5:00 PM
  */
object Spark04_RDD_Operator_Transform1 {

  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")

    val sc: SparkContext = new SparkContext(sparkConf)

    val rdd: RDD[String] = sc.makeRDD(List(

      "hello spark", "hello scala"
    ))
    val flatRDD: RDD[String] = rdd.flatMap(
      s => {
        s.split(" ")
      }

    )
    flatRDD.collect().foreach(println)



    sc.stop()


  }

}
