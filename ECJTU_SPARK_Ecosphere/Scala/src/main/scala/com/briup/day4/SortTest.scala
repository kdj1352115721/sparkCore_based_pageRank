package com.briup.day4


import scala.collection.mutable.ArrayBuffer

object SortTest {
 def main(args: Array[String]): Unit = {
   val ab: ArrayBuffer[Int] = ArrayBuffer(2,1,3,4,5)
   //默认排升序的
//   // sorted
//  val ab1: ArrayBuffer[Int] = ab.sorted
//  println(ab1)

//  def fun(i:Int) ={
//     i<3
//  }

//////  sortby  自定义排序规则的
//  val ab2: ArrayBuffer[Int] = ab.sortBy(elem =>{elem <2})
//  println("ab2"+ab2)

//
  // sortWith
  val ab3: ArrayBuffer[Int] = ab.sortWith((i, j)=>i<j)    //  i-j>0 排降序
  println(ab3)





 }




}
