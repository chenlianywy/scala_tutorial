package com.taiping.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author chenla
  * @create 2021-08-05 5:00 PM
  */
object Spark01_RDD_Operator_Transform_Par {

  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")

    val sc: SparkContext = new SparkContext(sparkConf)

    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4),2)

    val mapRDD1 = rdd.map(
      num =>{
        println(">>>>>>" + num)
        num
      }

    )

    val mapRDD2 = mapRDD1.map(
      num =>{
        println("######" + num)
        num
      }

    )

    mapRDD2.collect()

    sc.stop()


  }

}
