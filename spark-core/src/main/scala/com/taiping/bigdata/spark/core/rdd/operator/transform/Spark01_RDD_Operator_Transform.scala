package com.taiping.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author chenla
  * @create 2021-08-05 5:00 PM
  */
object Spark01_RDD_Operator_Transform {

  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")

    val sc: SparkContext = new SparkContext(sparkConf)

    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4))

    def mapFunction(num:Int)={
      num * 2
    }

//    val mapRDD: RDD[Int] = rdd.map(mapFunction)
    val mapRDD: RDD[Int] = rdd.map(_*2)
    

    mapRDD.collect().foreach(println)

    sc.stop()


  }

}
