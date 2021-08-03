package chapter06

/**
  * @author chenla
  * @create 2021-07-01 5:23 PM
  */
object Test15_TraitOverling {

  def main(args: Array[String]): Unit = {

      val student = new Student15

      student.increase()


    println("------------------------")
    val myFootBall = new MyFootBall

    println(myFootBall.describe())

    }

  }


trait  Ball{

  def describe():String ="ball"

}

trait ColorBall extends Ball{

  val color : String ="red"

  override def describe(): String = color +"--->"+ super.describe()
}

trait CategoryBall extends Ball{

  val category : String ="foot"

  override def describe(): String = category +"--->"+ super.describe()

}


class MyFootBall extends CategoryBall with ColorBall{

  override def describe(): String = "my ball is "+super[CategoryBall].describe()
}



  trait Talent15{

    def singing():Unit
    def dancing():Unit
    def increase():Unit={
      println("Talent15 increase")
    }
  }


  //定义一个特质

  trait Knowledge15{
    var amount :Int =0
    def increase():Unit={
      println("Knowledge increase")
    }
  }

  class Student15 extends Person13  with Knowledge15 with Talent15{

    override def dancing(): Unit = {println("dancing")}

    override def singing(): Unit = println("singing")

    override def increase(): Unit = {
      super[Person13].increase()
    }
  }

