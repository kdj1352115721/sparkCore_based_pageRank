package com.briup.day5.Seq

import scala.collection.immutable
import scala.collection.immutable.List

// LinearSeq/ list  /   :: ,Nil
object ListTest {
 def main(args: Array[String]): Unit = {
    // 右结合(head,tailList)    数 :: 右边是集合    集合  ：：：集合
       val l: List[Int] = 300::200::100::Nil
//       println(l)        // (300,200,100)
//       println(l.tail)       //    (200,100)
//       println(l.tail.tail)     //   (100)

      val l1: List[Int] = List(1,2,3,4,6)
      val it: Iterator[Int] = l1.iterator
      val r = l1.take(2)
      println(r)
      println(it.next())
//    def show(list:List[Int]):Unit={
//      list match {
//       case Nil => println("over")
//       case h::t => {println("h:"+h);show(t)}
//      }
//
//    }

//      l.productIterator
//      while (l.productIterator.hasNext){
//        println(l.productIterator.next())
//      }
 }
}
