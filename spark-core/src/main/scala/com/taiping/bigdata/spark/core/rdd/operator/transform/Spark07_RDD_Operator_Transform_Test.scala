package com.taiping.bigdata.spark.core.rdd.operator.transform

import java.text.SimpleDateFormat
import java.util.Date

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author chenla
  * @create 2021-08-05 5:00 PM
  */
object Spark07_RDD_Operator_Transform_Test {

  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")

    val sc: SparkContext = new SparkContext(sparkConf)

    val rdd: RDD[String] = sc.textFile("datas/apache.log")

    rdd.filter(
      line =>{
        val datas: Array[String] = line.split(" ")
        val time: String = datas(3)
        time.startsWith("17/05/2015")
      }

    ).collect().foreach(println)


    sc.stop()


  }

}
