package com.atguigu.prictice9

object Test9 {
 def main(args: Array[String]): Unit = {
 }
}


object Company{
   implicit val aaa ="zhangsan"
//   implicit val ccc ="lisi"
   implicit val bbb = 10000.00
}

class Boss{
 def callName()(implicit name:String):String ={
    name +"is coming !"
 }

 def getMoney()(implicit money:Double):String={
    "当月月薪："+money
 }

}

object Boss extends App{
  val boss: Boss = new Boss
  import Company._                   // 相同类型的隐式参数只能有一个，多个会产生歧义选择
  println(boss.callName())          // 隐式值得作用域在声明的那个对象大括号内
}
