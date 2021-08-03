package com.taiping.bigdata.spark.core.chapter08

/**
  * @author chenla
  * @create 2021-07-26 3:35 PM
  */
object Test05_MacthCaseClass {


  def main(args: Array[String]): Unit = {
    val student: Student1 = Student1("alice",11)

    //针对对象实例的内容进行匹配
    val result = student match {
      case Student1("alice",13) => "alice,13"
      case _ =>"Else"
    }


    println(result)
  }

}

//定义样例类
case class Student1(val name:String,val age:Int)