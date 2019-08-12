package com.atguigu.prictice3

import scala.collection.mutable

object test3 extends App  {
 //5   map的遍历处理操作
// var map: mutable.Map[String, Double] = mutable.Map("xuefulanXL"->80000,"cameiru"->90000,"Acoor"->85000)
// val map1= for((k,v) <- map) yield (k,v * 0.9)
//
// for((k,v)<-map1){
//  println("k:"+k+" "+"v:"+v)
// }

  // 6
  def wordCount(s:String)={
     var map = mutable.Map[String,Int]()
     val splits: Array[String] =s.split(",")
     for( i <- splits){
      if(map.contains(i)){
        map.+=((i,map.apply(i)+1))
      }else{
       map.+((i,1))
      }
     }
   for((k,v) <- map){
    println("k:"+k+" "+"v:"+v)
   }
  }
 // 选择map来存储 （word,数值）
//  def wordCount(s:String) ={
//    val count = mutable.SortedMap[String,Int]()
//    for (word <- s.split(",")){
//     count(word) = count.getOrElse(word,0) + 1
//    }
//      for((k,v) <- count){
//       println("k:"+k+" "+"v:"+v)
//      }
//      for((k,v)<- count)yield (k,v)
//    }
// wordCount("hello,hello,123,123,w,w,w,w,af,wf,a,a")

  // 10
//  def min_max(arr:Array[Int])={
//
//     val min: Int = arr.min
//     val max: Int = arr.max
//     val tuple = Tuple2(min,max)
//
//     val iter: Iterator[Any] = tuple.productIterator
//     while(iter.hasNext){
//        println(iter.next())
//     }
//  }
//  val arr = Array(1,2,8,97,6,3,4,0,-4)
//  min_max(arr)

//  def min_max(arr:Array[Int])={
//      (arr.min,arr.max)
//  }
//
//  println( min_max(Array(1,3,48,76,-2,14,4,541)))




}


