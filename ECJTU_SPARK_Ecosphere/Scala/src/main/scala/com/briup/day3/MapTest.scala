package com.briup.day3
import scala.collection.mutable
import scala.collection.mutable.Map



object MapTest extends App {

   val m1: mutable.Map[Int, String] = Map((1,"a"),(2,"b"))
   val m4: mutable.Map[Int, String] = Map[Int,String]((1,"alias"),(2,"bob"))
   //创建一个空的map(hashmap)
   val m5 = new mutable.HashMap[Int,String]()
    val c: Boolean = m1.contains(1)
   if(c){
    val d: Option[String] = m1.get(1)
    println(d.get)

   }
/*  println(m1)
   m1.-=(2)
  println(m1)*/
  for((k,v) <- m1){
   println("k:"+k+" "+"v"+v)
  }

 println("===================")
 val iterator: Iterable[Int] = m1.keys

 for(i <- m1.keys){
  println(i)
 }

 println("===================")
 for(i <- m1.values){
  println(i)
 }
 println("================")
 for(i <- m1){
  println(i)
 }


////   println(m1.getOrElse(1,"c"))
//   val m2: String =m1.getOrElse(3,"x")
//
//   //增
//   val m3 = m1.+=((3,"d"))
//   println(m1)
//   println(m4)

}
