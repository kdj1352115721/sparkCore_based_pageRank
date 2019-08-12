package com.briup.day6

object IteratorTest {
 def main(args: Array[String]): Unit = {
  val list: List[Int] = List(1,2,3,4)
  val list2: List[Int] = list.tail
  println(list2)  // 拿到除头元素之外的
  println("===========================")
  val list3: List[Int] = list.init
  println(list3)  // 拿到除尾元素之外的
  println("========================")
//  val b: Boolean = list.isEmpty
  val list4: List[Int] = list.slice(0,3)   //  (num,num]
  println(list4)
  println("=========================")
  val list5: Int = list.reverse.reduceLeft(_-_)
  println(list5)
  println("==============================")
  val list6: List[Int] = list.reverse.scanLeft(10)(_-_)
  println(list6)

 }



}
