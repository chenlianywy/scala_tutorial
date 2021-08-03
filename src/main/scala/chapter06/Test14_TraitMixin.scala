package chapter06

/**
  * @author chenla
  * @create 2021-07-01 4:14 PM
  */
object Test14_TraitMixin {

  def main(args: Array[String]): Unit = {

    val student = new Student14
    student.increase()
    student.dating()

    student.study()
    student.increase()

    student.play()
    student.increase()

    println("------------------------------")
    //动态混入

    val student1 = new Student14 with Talent{

      override def dancing(): Unit = println("dancing")

      override def singing(): Unit = {
        println("singing")
      }
    }

    student1.dancing()

  }
}

trait Talent{

  def singing():Unit
  def dancing():Unit

}


//定义一个特质

trait Knowledge{
  var amount :Int =0
  def increase():Unit
}


class Student14 extends Person13 with Young with Knowledge {

  override val name: String = "student"
  //实现抽象方法
  def dating(): Unit = println(s"student $name is dating")

  def study() :Unit = println(s"student $name is studying")

  override def sayHello(): Unit = {

    super.sayHello()
    println(s"hello from student $name")
  }

  override def increase(): Unit = {
    amount +=1

    println(s"student $name knowledge increase : $amount")

  }
}