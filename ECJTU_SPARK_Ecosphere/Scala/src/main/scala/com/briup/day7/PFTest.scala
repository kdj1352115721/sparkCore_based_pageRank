package com.briup.day7

object PFTest extends App {
   //偏函数 注意 是以 val pf 一个变量来接收的
   val pf:PartialFunction[Int,String] ={
    case 1 => "one"
    case 2 => "two"
    case _ => "any"
   }
   println(pf(1))
   println("======================")

   val v  = Vector(1,2,3,4)
   val v1: Vector[String] = v.collect(pf)
   v1.foreach(println)
   println("===============================")

   val v2: Vector[String] = v.map(pf)
   // 判断参数是否在偏函数的匹配域中
    println(pf.isDefinedAt(10))
   println("==============================")

}
