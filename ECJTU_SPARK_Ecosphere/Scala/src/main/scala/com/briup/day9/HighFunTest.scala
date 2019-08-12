package com.briup.day9

object HighFunTest {
 def main(args: Array[String]): Unit = {
  // 闭包
  def mulby(factor:Double) = {
   (x:Int) => factor * x
  }

  val tripe: Int => Double = mulby(3)
  // tripe 被称为闭包 ，包含上一个地方的局部变量（前女友的东西）
  println(tripe(5))
  //这里输入的参数是作为返回值的匿名函数的参数

  val triple2: Double = mulby(3)(2)
  println(triple2)
  println("====================")

  //科里化
  val a = Array("Hello","World")
  val b = Array("hello","world")

  a.corresponds(b)(_.equalsIgnoreCase(_))
  // 上下等价
  a.corresponds(b)((a,b)=>{a.equalsIgnoreCase(b)})

  def first(x:Int)(y:Int) = {
   x+y
  }

  def first1(x:Int) = {
   (y:Int)=> x+y
  }

 }
}



class A(c:C) {
def readBook(): Unit ={
println("A说：好书好书...")
}
}

class B(c:C){
 def readBook(): Unit ={
  println("B说：看不懂...")
 }
 def writeBook(): Unit ={
  println("B说：不会写...")
 }
}

class C()


object AB{  //创建一个类的2个类的隐式转换
 implicit def C2A(c:C)=new A(c)
// implicit def C2B(c:C)=new B(c)
}

object B{
 def main(args: Array[String]) {    //导包    //1. import AB._ 会将AB类下的所有隐式转换导进来    //2. import AB._C2A 只导入C类到A类的的隐式转换方法    //3. import AB._C2B 只导入C类到B类的的隐式转换方法
   import AB._
   val c: C =new C    //由于A类与B类中都有readBook()，只能导入其中一个，否则调用共同方法时代码报错    //c.readBook()    //C类可以执行B类中的writeBook()    c.writeBook()
    println(c.readBook())

  // 隐式只能将一个东西转成一个方向
 }
}

