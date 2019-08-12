package com.briup.day3
import scala.collection.immutable.Set
import scala.collection.mutable
object SetTest extends  App {

 // 默认不可变的Set
   val s1: Set[Int] = Set(1,2,3,4)
   val s2: mutable.Set[Any] = scala.collection.mutable.Set(1,2,3,"hello")

  s2.add("world")
  println(s2)
}
