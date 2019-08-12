package com.briup.day6

import java.util

import scala.collection.immutable.List
import scala.collection.mutable
import scala.collection.parallel.immutable.ParSeq
import scala.io.BufferedSource

object StreamTest extends App {
     def numsFrom(n: Long): List[Long] = {
      n :: numsFrom(n + 1)
     }

     def numsFrom1(n: Long): Stream[Long] = {
      n #:: numsFrom1(n + 1)
     }


     val s1: Stream[Long] = numsFrom1(10)
     println(s1)
     s1.take(3).foreach(elem => println(elem))
     println("=======================")
 // 构建Stream
 // apply ,  new Stream  , Stream.from()
    val s3: Stream[Int] = Stream.from(1,5)
    println(s3)
    s3.take(6).foreach(println)
   println("========================")

//   import scala.io.Source
//
//   val source1: BufferedSource = Source.fromFile("com.briup.day6.StreamTest")
//    val s4: Stream[Char] = source1.toStream

 println("========================")

 val list1 = List(1,2,3,4)
 // .par 并行的方法
 val list2: ParSeq[Int] =list1.par
 println(list1)
 list1.foreach(println)
 println(list2)
 list1.foreach(elem => println(elem+" "+Thread.currentThread().getName))
 println("========================")
 list2.foreach(elem => println(elem+" "+Thread.currentThread().getName))
 println("========================")
 val num: util.List[Int] = java.util.Arrays.asList(1,2,3,4)
 num.add(5)
 import scala.collection.JavaConverters._
 val s_num: mutable.Seq[Int] = num.asScala
 s_num.map(elem =>{elem*elem}).foreach(println)







}
