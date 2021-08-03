package com.taiping.bigdata.spark.core.chapter08

/**
  * @author chenla
  * @create 2021-07-26 3:21 PM
  */
object Test04_MatchObject {

  def main(args: Array[String]): Unit = {
    val student: Student = new Student("alice",13)

    //针对对象实例的内容进行匹配
    val result = student match {
      case Student("alice",13) => "alice,13"
      case _ =>"Else"
    }


    println(result)
  }



}


class Student(val name:String,val age:Int)

object Student{

  def apply( name: String,age: Int): Student = new Student(name,age)

  def unapply(student: Student): Option[(String, Int)] = {
    if (student == null){
      None
    }else{
      Some((student.name,student.age))
    }
  }
}