package com.atguigu.prictice3

import scala.collection.{SeqView, immutable}
import scala.collection.mutable.ArrayBuffer
import scala.collection.parallel.ParSeq

object atguigu_test extends App {
   val a1: Array[String] = Array("ailas","bob","chris","divin")
   val a2: Array[String] = a1.sorted
   val a3: String =a1.mkString("and")
    println(a3)
   println("==================")

   val a5: String = a1.mkString("<",",",">")
   println(a5)
   println("====================")
  for( i <- a2){
    println(i)
  }
  println(a2)
  val a4: Unit = scala.util.Sorting.quickSort(a1)
   println("==================")
   for(i <- a1){
     println(i)
   }
  println("===================")

   val a6 = Array(1,3,4,-1,9,-1,0)

   val r: Int = a6.count(_>0)

   println(r)
   println("=====================")

   val ab = ArrayBuffer(1,2,3,4)

   ab.append(1,6,2,0,6)

   ab+=100
    println(ab)

   val ab1: ArrayBuffer[Int] = ab.padTo(20,-1)
   println(ab)
   println(ab1)

 println("========================")

   val map1  =  Map(1->"a",2->"b",3->"c")
   val map2: Map[Int, String] = map1.+(4->"d")
   map1.foreach(println)
   println("============")
   map2.foreach(println)

  println("=======================")

   val arr1 = Array(1,2,3)
   val arr2 = Array("a","b","c","d")

   val arr3: Array[(Int, String)] = arr1.zip(arr2)

   arr3.foreach(println)

   val arr4: Array[(Any, String)] = arr1.zipAll(arr2,"A","B")
   println("===========")
   arr4.foreach(println)

   println("===========")
   val u: (Array[Any], Array[String]) = arr4.unzip
   u._1.foreach(println)
   println("=================")

//   val u1 = arr4.unzip3
   println("=========================")

   val list = List(1,2)

   val list2: List[Int] = 5 :: list
   println(list2)
   println("===========================")

    val list3: List[Int] =  7 :: 6 :: 5 :: Nil
   println(list3)
   println("==========================")

   def sum (list:List[Int]):Int={
     if(list == Nil) 0
     else {
        list.head+sum(list.tail)
     }
   }
  println(sum(list3))

  def sum1(list:List[Int]):Int = list match {
   case Nil => 0
   case h::t => h + sum(t)
  }
  println("===============")
  println(sum1(list3))

  println("======================")
  val l1: List[Int] = List(1,2,3)
  val l2: List[Int] =  3 :: l1

 println(l2)
println("=========================")

 val map5 = scala.collection.mutable.Map[Char,Int]()

 for(c <- "Mississppi"){
  map5(c) =  map5.getOrElse(c,0)+1
 }
 println(map5)
println("========================")
 val map6 = scala.collection.mutable.Map[Char,Int]()
 (map6 /: "aligaduokawayi")  {
  (m,c) => m + (c -> (m.getOrElse(c,0)+1 ) )
 }

 println(map6)
 println("=============")
 // view 的懒机制
 val a: Range.Inclusive =(1 to 100)
 val b: SeqView[Int, Seq[_]] = a.view.map(elem => { println(elem) ; elem*elem})

 b.take(10).mkString(",")

 println("-===========================")
 // par 多线程的并行
b.par.foreach(elem => println(Thread.currentThread().getName) )











}
