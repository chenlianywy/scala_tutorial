package chapter06

/**
  * @author chenla
  * @create 2021-07-01 3:48 PM
  */
object Test13_Trait {

  def main(args: Array[String]): Unit = {

    val student = new Student13
    student.sayHello()
    student.dating()
    student.study()
    student.play()

  }

}


//定义一个父类
class Person13{

  val name :String ="person"
  var age :Int = 23

  def sayHello()={
    println("hello from " + name)
  }

  def increase():Unit={
    println("Person13 increase")
  }
}


//定义一个特质

trait Young{
  // 申明抽象和非抽象属性
  var age :Int
  val name :String ="young"

  //声明抽象和非抽象方法

  def play()={
    println("young people is playing")
  }

  def dating() :Unit

}

class Student13 extends Person13 with Young{

  override val name: String = "student"
  //实现抽象方法
  def dating(): Unit = println(s"student $name is dating")

  def study() :Unit = println(s"student $name is studying")

  override def sayHello(): Unit = {

    super.sayHello()
    println(s"hello from student $name")
  }


}