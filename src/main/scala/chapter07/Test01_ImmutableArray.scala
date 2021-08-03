package chapter07

/**
  * @author chenla
  * @create 2021-07-02 4:15 PM
  */
object Test01_ImmutableArray {

  def main(args: Array[String]): Unit = {

    val arr = new Array[Int](5)

    val arr2 = Array("aa","bb","cc")

    arr(0)= 12
    arr(1)= 123
    arr(4)= 12312

    arr.update(1,222)


    println(arr(0))
    println(arr(1))
    println(arr(4))
//    println(arr(5))

    println("=================")

    for (i <- 0 until arr.length){
      println(arr(i))
    }

    println("-----------------")

    for(i <- arr.indices){

      println(arr(i))
    }

    println("-----------------")
    // 2.增强for循环

    for(elem <- arr2){
      println(elem)
    }

    println("--------3---------")
    //3.迭代器的使用

    val iter = arr2.iterator

    while (iter.hasNext)
      println(iter.next())

    println("--------4---------")
    //4.调用foreach 方法

    arr2.foreach((elem :String) => println(elem))

    arr.foreach(println)

    println(arr2.mkString("->"))

    println("--------5---------")
    //5.添加元素

    val newArr = arr2:+("dd")

    println(arr2.mkString("->"))
    println(newArr.mkString("->"))


    val newArr2 =newArr.+:("ee")

    println(newArr2.mkString("->"))

    val newArr3 = newArr2:+ "ff"

    val newArr4 = "gg"+: "hh" +: newArr3

    println(newArr3.mkString("-->"))
    println(newArr4.mkString("-->"))
  }

}
