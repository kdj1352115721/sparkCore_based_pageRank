package com.briup.day3

import scala.collection.mutable

object ArrayTest extends App {
 // scala

   // 创建
// 1.类模型：
 val array1 = new Array[Int](5)
 //2.对象的同一构建原则  伴生对象的Apply()方法    形式
  val array: Array[String] = Array("1","2","3","4")
  val array5: Array[Any] = Array(1,"a")
  val array6: Array[String] = Array[String]("1","2")
  val Array(a,b,c,d) = Array("alias","bob","cluo","dd")
 // 3.空数组
  val array2: Array[Nothing] = Array.empty
 //===========================================================
 //元素访问
 //类的apply
//  println("第一个值："+array(0))
// println(array2(0))
// println("a:"+a)
 //遍历
//  array.foreach((i)=>{println(i)})
//  array.foreach(println _)   // _ 代替前面的一个参数
//  array.foreach(println)
//
//  for(i  <- 0 to  array.length -1){
//   println(array(i))
//  }


 //方法
 // ++ 添加一个数组，形成新的数组   +:   ++:   clone()   addString()  toBuffer()
   val a2: Array[String] = array.+:("6")
   a2.foreach(println)
  println("=================")
  val a3 = ("7") +:a2           //  :在哪 ，数组往哪放 ， 将 7 加进 a2
   a3.foreach(println)
 //===================================
 println("=============")
  val sb = new StringBuilder
  a3.addString(sb)
  a3.foreach(print)
 //=================================  collecttion.mutable.buffer
 println("==========")
 val a4: mutable.Buffer[String] = a3.toBuffer
 a4.foreach(println)



}
