package com.briup.day3
import scala.collection.mutable

object QueueTest {
 def main(args: Array[String]): Unit = {

 }

 val q = new mutable.Queue[String]()
 q.+=:(("1"))
 q.+=:(("hello"))
 println(q)
 //取出头好元素
 q.dequeue()
 println(q)
 //尾部进队列
 q.enqueue("2","3","4")
 println(q)
 //拿到把除第一个之外的数据
 val q5: mutable.Queue[String] = q.tail
 println(q5)
 q.foreach( i => {println(i)})
 val q1: mutable.Queue[Int] = mutable.Queue(1,2,3,4)

}
