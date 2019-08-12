package com.atguigu.prictice5

import scala.collection.mutable.ListBuffer

object test5 extends App {
  // 1  高阶函数    参数 2个不同处理的函数，返回其中一个
   def compose(f1:Double=>Option[Double],f2:Double=>Option[Double]):Double=>Option[Double]={
      (x:Double) => if(f1(x).==(None) || f2(x).==(None)) None
       else f1(x)
   }

  import scala.math.sqrt
  def f(x:Double) = {
      if(x>=0) Some(sqrt(x)) else None
  }
  def g(x:Double) ={
       if(x != 1) Some(1 / (x-1)) else None
  }

  val com = compose(f _,g _)

  println(com(4.0))


 println("===============================")
  // 2  给定一个区间，一个函数操作  作为参数，需要根据函数去将区间内的每一个值进行相应的操作
 import scala.collection.mutable
  def values(fun:(Int) => Int,low:Int,high :Int):mutable.Map[Int,Int]={
     val map2 = mutable.Map[Int,Int]()
      if(low <= high){
         low to high foreach{
           x => map2.+=((x,fun(x)))
         }
      }else{
        println(" low must < high !")
     }
        map2
  }
   println(values(x=>x*x,5,5))

 // 3
   println("===============================")
//    var max =0
//    for(elem <- arr3){
//       max = arr3.reduceLeft{ (l, elem)=>if(l>elem) l else elem }
//    }

 val arr3 = Array(1,333,4,6,4,4,9,32,6,9,0,2)
 println(arr3.reduceLeft((l,r)=> if(l>r) l else  r))





}

