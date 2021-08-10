package com.taiping.bigdata.spark.core.rdd.operator.transform

import java.text.SimpleDateFormat
import java.util.Date

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author chenla
  * @create 2021-08-05 5:00 PM
  */
object Spark06_RDD_Operator_Transform_Test {

  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")

    val sc: SparkContext = new SparkContext(sparkConf)

    val rdd: RDD[String] = sc.textFile("datas/apache.log")

    val timeRDD: RDD[(String, Iterable[(String, Int)])] = rdd.map(
      line => {
        val datas: Array[String] = line.split(" ")
        val time: String = datas(3)
        val sdf: SimpleDateFormat = new SimpleDateFormat("dd/MM/yyyy:HH:mm:ss")
        val date: Date = sdf.parse(time)
        val sdf1: SimpleDateFormat = new SimpleDateFormat("HH")
        val hour: String = sdf1.format(date)
        (hour, 1)
      }

    ).groupBy(_._1)

    timeRDD.map{
      case (hour,iter) =>{
        (hour,iter.size)
      }
    }.collect().foreach(println)


    sc.stop()


  }

}
