package com.atguigu.prictice2

object test2 extends App {
// var signum = 0
// var t: Unit = ()
//
// fun(-1)
// println(signum)
//
// def fun (num:Int) = {
//  if(num>0) signum = 1
//  else if(num <0 ) signum = -1
//  else signum =0
// }

 // 3.
// for( i <- 0 to 10){
//  println(i)
// }
 // 4  过程

// def countdown(n:Int) {
//  for( i <- 0 to n reverse){
//   println(i)
//  }
// }
// countdown(10)

  // 5
// var sum: Long = 1
 //// def fun(s:String):Long = {
 ////  for (i <- s) {
 ////   fun_in(i)
 ////  }
 ////  def fun_in(char: Char) = {
 ////   sum = sum.*(char.toLong)
 ////  }
 ////   sum
 //// }
 ////  println(sum)

  //5

// var  t1:Long = 1
//  for( i<- "Hello"){
//   t1 = t1 * i.toLong
//  }
// println(t1)

 // 6
//  var t:Long =1
//  "Hello".foreach(elem => {println(elem); t =t*elem.toLong ; println(t) })

//7

// def prodect(s:String) ={
//  for(i <- s ){
//    t = t * i.toLong
//  }
//  println("==========")
// }
// prodect("Hello")
//  println(t)

// def fun1(s:String) ={
//  for ( i <- s){
//    fun2(i)
//  }
//  def fun2(c:Char) ={
//     t = t * c.toLong
//  }
// }
// fun1("Hello")
// println(t)
   //9
 var sum:Double = 1
 def x(x:Int,n:Int) ={
  if(n>0) {
   for( i <- 1 to n){
    sum = sum.*(x)
   }
  }else if(n<0){

  }else{
   sum = 1
  }
  sum
 }
 val r: Double = x(8,2)
 println(r)






 }