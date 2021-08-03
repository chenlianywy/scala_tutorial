package chapter06

/**
  * @author chenla
  * @create 2021-07-01 2:39 PM
  */
object Test12_Singleton {

  def main(args: Array[String]): Unit = {

    val student1 = Student12.getInstance()
    student1.printInfo()

    val student2 = Student12.getInstance()
    student2.printInfo()

    println("------------------")
    println(student1)
    println(student2)

  }

}


//定义类
class Student12 private (val name :String,val age :Int){

  def printInfo(): Unit ={
    println(s"student: name=${name},age=$age,school =${Student11.school}")
  }
}


//伴生对象(饿汉shi)
/*object Student12{

  private val student :Student12 = new Student12("lisi",12)

  def getInstance():Student12= student

}*/


//懒汉式

object Student12{

  private var student :Student12 = _

  def getInstance() :Student12 ={

    if (student == null){
      //如果没有实例对象的话，就创建一个

      student = new Student12("lisi",12)


    }

    student
  }


}

