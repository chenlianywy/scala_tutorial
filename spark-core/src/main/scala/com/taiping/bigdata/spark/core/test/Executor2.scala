package com.taiping.bigdata.spark.core.test

import java.io.{InputStream, ObjectInputStream}
import java.net.{ServerSocket, Socket}

/**
  * @author chenla
  * @create 2021-07-28 9:43 AM
  */
object Executor2 {

  def main(args: Array[String]): Unit = {

    //启动服务，接收数据
    val server: ServerSocket = new ServerSocket(8888)
    println("服务器启动，等待接受数据")

    //等待客户端的连接
    val client: Socket = server.accept()


    val in: InputStream = client.getInputStream

    val objIn: ObjectInputStream = new ObjectInputStream(in)

    val task: SubTask = objIn.readObject().asInstanceOf[SubTask]

    val list: List[Int] = task.compute()

    println("接收到客户端[8888]发送的数据：" + list)

    objIn.close()

    client.close()

    server.close()
  }

}
