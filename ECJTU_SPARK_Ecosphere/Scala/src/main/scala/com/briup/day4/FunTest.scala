package com.briup.day4
import scala.collection.GenTraversableOnce



object FunTest extends App{

 val list = List("alias","bob","chris")


 //map   转化
 val list1: List[String] = list.map(fun)
  println(list1)
 // filter   // 把符合的留下
 val list2: List[String] = list.filter(fun1)
 println(list2)
 // flatemap    处理到不可分割为止
 val list3: List[Char] = list.flatMap(fun)
 println(list3)



 def fun(s:String):String={
  s.toUpperCase
 }

 def fun1(s:String):Boolean={
  s.equals("bob")
 }




// test(sayHello)
//
// def test( f:()=>Unit) ={
//   f()
// }
// def sayHello():Unit={
//  println("hello")
// }

}
