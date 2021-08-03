package com.taiping.bigdata.spark.core.chapter08

/**
  * @author chenla
  * @create 2021-07-22 3:35 PM
  */
object Test01_PatternMatchBase {

  def main(args: Array[String]): Unit = {

    val x :Int = 12;
    val y:String = x match {
      case 1 => "one"
      case 2 => "two"
      case 3 => "three"
      case _ => "other"
    }

    println(y)

    //2.
    val a = 12
    val b = 15

    def matchDualOp(op:Char) = op match {
      case '+' => a+b
      case '-' => a-b
      case '*' => a*b
      case '/' => a/b
      case '%' => a%b
      case _ => "非法字符"
    }

    println(matchDualOp('+'))
    println(matchDualOp('%'))
    println(matchDualOp('\\'))
    println(matchDualOp('/'))

    println("---------------------")


    //3.模式守卫

    def abs(num :Int) ={
      num match {
        case i if i >= 0 => i
        case i if i < 0 => -i
      }
    }

    println(abs(12))
    println(abs(-23))
    println(abs(0))

  }

}
