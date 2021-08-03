package chapter06

/**
  * @author chenla
  * @create 2021-07-01 2:17 PM
  */
object Test11_Object {//单例对象

  def main(args: Array[String]): Unit = {
//    val student = new Student11("zhangdan",20)

//    student.printInfo()


    val student1 = Student11.newStudent("lyx",24)
    student1.printInfo()

    val student2 = Student11.apply("cla",24)
    student2.printInfo()

    val student3 = Student11("aaaaa",24)
    student3.printInfo()

  }



}

//定义类
class Student11 private (val name :String,val age :Int){

  def printInfo(): Unit ={
    println(s"student: name=${name},age=$age,school =${Student11.school}")
  }
}

//伴生对象

object Student11{
  val school: String ="taiping"

  //定义一个类的对象实例的创建方法

  def newStudent(name:String,age:Int):Student11 = new Student11(name,age)

  def apply(name: String, age: Int): Student11 = new Student11(name,age)
}


