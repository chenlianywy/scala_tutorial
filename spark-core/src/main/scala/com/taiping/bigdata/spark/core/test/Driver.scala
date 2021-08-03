package com.taiping.bigdata.spark.core.test

import java.io.{ObjectOutputStream, OutputStream}
import java.net.Socket

/**
  * @author chenla
  * @create 2021-07-28 9:42 AM
  */
object Driver {


  def main(args: Array[String]): Unit = {

    val client1 = new Socket("localhost",9999)
    val client2 = new Socket("localhost",8888)

    val task = new Task

    val subTask1 = new SubTask()
    subTask1.logic = task.logic
    subTask1.datas = task.datas.take(2)



    val out1: OutputStream = client1.getOutputStream

    val objOut1: ObjectOutputStream = new ObjectOutputStream(out1)



    objOut1.writeObject(subTask1)
    objOut1.flush()
    objOut1.close()

    client1.close()



    //------------------------------------


    val subTask2 = new SubTask()
    subTask2.logic = task.logic
    subTask2.datas = task.datas.takeRight(2)



    val out2: OutputStream = client2.getOutputStream

    val objOut2: ObjectOutputStream = new ObjectOutputStream(out2)



    objOut2.writeObject(subTask2)
    objOut2.flush()
    objOut2.close()

    client2.close()

    println("客户端数据发送完毕。。。")


  }
}
