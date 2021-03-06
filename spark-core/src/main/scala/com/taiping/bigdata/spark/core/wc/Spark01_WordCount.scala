package com.taiping.bigdata.spark.core.wc

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author chenla
  * @create 2021-07-14 11:03 AM
  */
object Spark01_WordCount {

  def main(args: Array[String]): Unit = {

    //  TODO 建立和spark框架的连接
    val sparkConf = new SparkConf().setMaster("local").setAppName("wordCount")

    val sc = new SparkContext(sparkConf)

    //    1.读取文件，获得一行一行数据
    val lines: RDD[String] = sc.textFile("datas")

    //    2.将一行数据进行茶拆分，形成一个一个单词（分词）
    val words = lines.flatMap(_.split(" "))

    //    3.将数据根据单词分组，便于统计
    val wordGroup: RDD[(String, Iterable[String])] = words.groupBy(word => word)

    //    4。对分组后的数据进行转换
    val wordToCount = wordGroup.map {
      case (word, list) => {
        (word, list.size)
      }
    }

    //    5。将转换结果采集到控制台打印出来
    val array = wordToCount.collect()
    array.foreach(println)

    //  TODO 关闭连接
    sc.stop()

  }
}
