package com.briup.day6


//   模式匹配得益于unapply方法
//  样例类的模式匹配,声明样例类时，会自动完成5件事
// 1 将参数声明为val
// 2 为伴生对象自动提供apply方法，
// 3 提供unapply方法为模式匹配提供
// 自动提供toString(),copy(),等方法
abstract sealed  class Acount
case class A(d:Double) extends Acount
case class B(d:Double,s:String) extends Acount
case object Nothing extends Acount

object MatchTest {
 def main(args: Array[String]): Unit = {

  def f:PartialFunction[Char,Int] = {
   case '+' =>  1
   case '-' =>  0
   case _ => 2
  }
 println(f(3))

//  for(amt <- Array(A(1000.0),B(10000.0,"B_S_R"),Nothing)){
//   val result = amt match {
//    case A(d) => "A+"+d
//    case B(_,u) =>s"oh,yes ,i have got the $u"
//    case Nothing => "nothing"
//   }
//   println(amt+":"+result)
//
//  }
//
//  println("======================")
//  val amt: B = B(1000.0,"BSR")
//  val price: B = amt.copy(d= 18)
//
//  println(amt)
//  println(price)


  // 1.变量 ：     如果匹配成，用一个变量去接收匹配项
  // case x => 10 * x         x is val ,局部变量

  // 常量 ：      匹配一个值是否一样
  //  val pi = 3.14
  // case  `pi` => println("number is pi")  使用之前声明的常量，不使用反引号，会被当成是用一个变量去接收匹配项。

  // 数组 ：      匹配数组内结构
  // 序列：     匹配seq内部结构
  //  1带有 unapply()
  //  2 _  ,_*
  // case List(_,_,_,_) = > println("list size is 4")
  // case List(10,20,_,_)  => println()
  // case List(10,20,x,y,_)  => println(s"list size is 5,x is $x,y is $y")
   // case Vector(10,_*) => println("is a vctor, first of what is 10")
  // case _ => println("default")

  // 类型 ：    匹配是否同一个类型
  // case i:Int => println(s"number is Int $i")   需要将i再次使用
  // case _:Int => println("number is Int")
//  case List[Int] => println("is a list ")   集合中其中的泛型会被在编译时被檫除，没有用在这写泛型
  // 数组是可以匹配到类型的，Array[String]  String这个不是泛型
  // 元组 ：  case c:(String,String,Int) => println("tuple3(s,s,i)")

   // 值：      匹配是否同一个值
  // 7.元组：
//  x match {
//   case (String,Int) => println("tuple2 (String,Int)")
//   case (10,_,_) => println("tuple3(10,_,_)")
//   case (10,_,a) => println(s"tuple3(10,_,$a)" )
//  }


//  val a: Any ="1,22,30".split(",")
//  // a 必需是Any 类型的
//   a match {
//   case "1" => println("1")
//   case "22" => println("22")
//   case  "30" => println("30")
//    //做成一个封闭项，任何都能匹配到，不漏掉任何一个
//   case _ => println("something else")
//  }

   }
}
