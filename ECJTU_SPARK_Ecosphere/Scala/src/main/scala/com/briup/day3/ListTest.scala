package com.briup.day3
import scala.collection.GenTraversable
import scala.collection.immutable.List
import scala.collection.mutable.ListBuffer

object ListTest extends App {
   val list: List[Int] = List(1,2,3,4)
   val list1: List[String] = List("1","2","3","4")  // 调用了List对象的apply()方法其中的to（）方法
   val listB: ListBuffer[Int] = new ListBuffer[Int]
//
//   //遍历
//  list1.foreach(println)
//  //map
//  val list2: List[String] = list1.map(elem => elem+"2")
//  val list4 = list1.map{ println("hello");_+"2"}
//  println("=============")
//  list2.foreach(println)
//  //flatmap
//  val list3: List[String] = list1.flatMap(elem => elem.split(""))

  //reduceLeft
//   val list3: Int = list.reduceLeft(_+_)
//   list.reduce
//   println(list3)






}
