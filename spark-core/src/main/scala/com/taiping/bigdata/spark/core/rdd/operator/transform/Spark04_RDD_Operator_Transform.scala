package com.taiping.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author chenla
  * @create 2021-08-05 5:00 PM
  */
object Spark04_RDD_Operator_Transform {

  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")

    val sc: SparkContext = new SparkContext(sparkConf)

    val rdd: RDD[List[Int]] = sc.makeRDD(List(

      List(1, 2), List(3, 4)
    ))
    val faltRDD: RDD[Int] = rdd.flatMap(
      list => {
        list

      }

    )
    faltRDD.collect().foreach(println)


    sc.stop()


  }

}
