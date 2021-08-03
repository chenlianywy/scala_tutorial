package com.taiping.bigdata.spark.core.test

/**
  * @author chenla
  * @create 2021-07-28 10:04 AM
  */
class Task extends Serializable {

  val datas = List(1,2,3,4)

  val logic:(Int) => Int = _ * 2

  //计算

  def compute()={
    datas.map(logic)
  }

}
