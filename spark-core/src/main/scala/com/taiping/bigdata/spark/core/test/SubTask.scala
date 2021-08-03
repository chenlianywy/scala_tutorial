package com.taiping.bigdata.spark.core.test

/**
  * @author chenla
  * @create 2021-07-28 10:04 AM
  */
class SubTask extends Serializable {

  var datas:List[Int] = _

  var logic:(Int) => Int = _

  //计算

  def compute()={
    datas.map(logic)
  }

}
