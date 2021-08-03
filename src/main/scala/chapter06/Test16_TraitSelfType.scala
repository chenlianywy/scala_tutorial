package chapter06

/**
  * @author chenla
  * @create 2021-07-02 1:47 PM
  */
object Test16_TraitSelfType {

  def main(args: Array[String]): Unit = {

    val user = new RegisterUser("zhangsan","123123")
    user.insert()
  }

}


//用户类
class User(val name:String,val password: String)

//特质
trait UserDao{

  _: User =>

  //像数据库插入数据
  def insert()={
    println(s"insert into db : ${this.name}")
  }
}


//注册用户类
class RegisterUser( name:String, password :String ) extends User(name,password) with UserDao