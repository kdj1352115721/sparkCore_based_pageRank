package com.atguigu.prictice5

object test5again extends  App {
  // 1
 def compose(f:Double=>Option[Double],g:Double=>Option[Double]):Double=>Option[Double]={
  (x:Double) => if(f(x) == None || g(x) == None) None else{
    if(x==1 || x == 2) g(x)
    else f(x)
  }
 }

 def f(x:Double) ={
  import scala.math.sqrt
  if(x>0) Some(sqrt(x)) else None
 }

 def g(x:Double) ={
  if(x !=1) Some(1 / (x-1)) else None
 }
 val h: Double => Option[Double] = compose(f,g)
 println(h(2))
 println(h(1))
 println(h(0))

 // 2
 def values(fun:Int => Int,low:Int,high:Int) ={
    import scala.collection.mutable.ArrayBuffer
    var ab = ArrayBuffer[(Int,Int)]()
    low to high foreach {       //  重点：只给出两个数的遍历，区间的遍历方式 ,构成一个Range去调用函数方法
        x =>                   // 只要函数符合这个规范就行 ！！
        ab.+=((x:Int,fun(x)))
    }
    ab
 }
  println(values( (x=>x*x),-5,5))
  // 3      refuceLeft 函数的应用
   val arr: Array[Int] = Array(1,333,4,6,6,44,4,32)
   val r: Int = arr.reduceLeft((x, y)=>{if(x>y) x else y })
   println(r)

  println("===============")
  // 4   实现阶乘       n!= n x (n-1) x (n-2) ...... x 1
   def factorialImpl(n:Int)  ={
      val r: Int =  1 to n reduceLeft((x, y) => x*y)
//    1 to n reduceLeft(_*_)
   }
   println(factorialImpl(3))

 println("===============")
  // 5
  def largest(fun:Int=>Int,inputs:Seq[Int]) ={
//        inputs.reduceLeft((x,y)=>if(fun(x) > fun(y)) fun(x) else fun(y))
          inputs.foldLeft(1)((x,y)=> if(fun(y)> x)fun(y) else  x)   // 这里后面的x 是经过了一次 x = fun（x）
//         inputs.map(fun(_)).max
  }
  println(largest(x=>10*x-x*x,1 to 10))
  println("===============")
 // 6

 def largest1(fun:Int=>Int,inputs:Seq[Int]) ={
  //        inputs.reduceLeft((x,y)=>if(fun(x) > fun(y)) fun(x) else fun(y))
  inputs.foldLeft(1)((x,y)=> if(fun(y)> x)fun(y) else  x)
  //         inputs.map(fun(_)).max
 }
 println(largest1(x=>10*x-x*x,1 to 10))







}
