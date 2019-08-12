package com.briup.day2

import scala.collection.immutable
class User(var name:String,var age:Int){

}
object StandOutTest extends App {
  //day2作业：
/*   val b: User = new User("bob",33)
   val c: User = new User("chris",44)
   val d: User =new User("divid",23)
   val a: User =new User("alias",28)
   val userBase: immutable.Seq[User] = List(b)
   userBase.*/
  /* userBase.filter(user=>user.age.>=(30))
    .foreach(user => println(user.name))*/
//   userBase.foreach(user => println(user.name))








 //函数的创建
  /*val fun1: (Int, Int) => Int = (a:Int, b:Int) => a+b
  println("fun1:"+fun1(1,2))


  class FunTest extends Function2[Int,Int,Int]{
   override def apply(v1: Int, v2: Int): Int = v1+v2
  }
 val test: FunTest = new FunTest
 println("test:"+test(1,2))

  def fun2(a:Int,b:Int):(String,String)=>String = {
    def fun3(s1:String,s2:String)={
     s1+"-"+s2
    }
   fun3
  }
 def fun4(a:Int,b:Int):Int={
  a+b
 }

  val test2: (Int, Int) => Int = fun4 _

//  val test3: (String, String) => String = fun2(1,2) _
// val test3: Unit = println() _
  println("test2:"+test2(1,2))



*/




/*println("hello")
val str = scala.io.StdIn.readLine()

 println(str)
 for(i <- 1 to 5){
  println("*"*i)

 }*/
//val r: immutable.Seq[Boolean] = for(i<- 1 to 10) yield (i%2 ==0);
//  import scala.util.control.Breaks._
//  breakable{
//   for(i <- 1 to 10){
//    for(j <- 1 to i){
//      if(i==9) break
//      print("i="+i +"------------"+j)
//    }
//    println
//   }
//
//  }






}
