package com.briup.day8

object FunctionTest extends App {
     // 函数声明
    // 1
    val f = (f:String) => {println(f)}

   // 2
   val f1 = new Function[String,Unit] {
    override def apply(v1: String): Unit = {
      println(v1)
    }
   }


  // 接收：

 // 匿名函数  , 该函数就是一个对象,整体可直接调用方法
 (a:Int,b:Int) => a+b
 // 中缀方法有语法糖（单参）

 //作为高阶函数的参数，类型推断
 import scala.math._
 (1 to  10).map((x:Int)=>{pow(x,2)})
 (1 to  10).map((x)=>{pow(x,2)})
 (1 to  10).map(x=>pow(x,2))
 // 参数只使用了一次
 (1 to  10).map(_=>pow(_,2))
 (1 to  10).map(pow(_,2))
 // ETA （方法转函数）
 println("==========================")
  //  传值调用（传入一个值），传名调用（传入一个函数），函数在调用时才会运行得到结果
 (1 to 10).foreach((x:Int)=> show(x))

 (1 to 10).foreach(show)

 def show(i :Int)={
  println("--------------------")
  println(i)
 }




}
