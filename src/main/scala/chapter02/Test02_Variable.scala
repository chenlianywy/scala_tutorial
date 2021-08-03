package chapter02

/**
  * @author chenla
  * @create 2021-06-15 8:29 PM
  */
object Test02_Variable {

  def main(args: Array[String]): Unit = {

    var a = 10
//    println(a)


    var name = "tom"
    var age = 23

    println(name +"今年"+ age+"岁！")

    printf("%s今年%d岁",name,age)
    println()
    println("-----------------")

    val person = new Person
    println(person.name)
    person.eat()


  }

}


class Person {
  var name = "alice"
  def eat():Unit ={
    println("person eat")
  }
}