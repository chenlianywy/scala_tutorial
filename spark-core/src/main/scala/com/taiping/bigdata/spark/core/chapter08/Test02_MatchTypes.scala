package com.taiping.bigdata.spark.core.chapter08

/**
  * @author chenla
  * @create 2021-07-22 3:55 PM
  */
object Test02_MatchTypes {

  def main(args: Array[String]): Unit = {

    //1.匹配常量
    def describeConst(x :Any) =x match {
      case 1 => "Int One"
      case "hello" => "String hello"
      case true => "Boolean True"
      case '+' => "Char +"
      case _ =>""
    }

    println(describeConst("hello"))
    println(describeConst('+'))
    println(describeConst(0.3))
    println(describeConst())


    //2.匹配类型
    def describeType(x:Any) = x match {
      case i:Int => "Int" + i
      case s:String => "String" + s
      case list:List[Int] => "List  :" + list
      case array:Array[Int] => "Array  :" + array.mkString(",")
      case a => "Something else" + a

    }

    println("-------------------------")
    println(describeType(35))
    println(describeType("hello"))
    println(describeType(List("hi","hello")))
    println(describeType(List(1,3)))
    println(describeType(Array("hi","hello")))
    println(describeType(Array(1,3)))

    println("-------------------------")

    for(arr <- List(
      Array(0),
      Array(1,0),
      Array(0,1,0),
      Array(1,1,0),
      Array(2,3,7,15),
      Array("hello",20,30),
    )){
      val result = arr match {
        case Array(0) => "0"
        case Array(1,0) => "Array(1,0)"
        case Array(x,y) => "Array:" + x +", " + y
        case Array(0,_*) => "以0开头的数组"
        case Array(x,1,z) => "中间为1 的三元素数组"
        case _ => "someThing else"
      }

      println(result)
    }

    println("--------------------------")
    //4.匹配列表
    for(list <- List(
      List(0),
      List(1, 0),
      List(0 ,0 , 0),
      List(1 ,1 , 0),
      List(88),
      List("hello")

    )){
      val result = list match {
        case List(0) => "0"
        case List(x,y) => "List(x,y): " + x + ", " + y
        case List(0,_*) => "List(0,.....)"
        case List(a) => "List(a) : " + a
        case _ => "someThing else"

      }

      println(result)

    }

    println("--------------------")
    //方式二
    val list =List(1,2,3,5,7)
    list match {
      case first :: second :: rest => println(s"first:$first, secind:$second, rest:$rest")
      case _ => println("something else")
    }

    println("--------------------")
    //5.匹配元组


  }

}
