package com.briup.day7

object TypeTest extends  App {

//  val p = new PairSec04(4,2)
//  val p1: Int = p.smaller
//  println(p1)
  val p = new Pair[Int](1,2)
  val p1 = p.smaller
 println(p1)



}

class PairSec04[ T <% Comparable[T]](val first: T ,val second: T){
  def smaller = if (first.compareTo(second) < 0 ) first else second
 override def toString: String = "("+ first +","+second + ")"
}

// 传入一个隐式参数ord
class Pair[T: Ordering](val first:T,val second:T){
 def smaller(implicit ord:Ordering[T]) ={
   println(ord)
   if(ord.compare(first,second)<0 )first else second
 }

 override def toString: String = "("+ first +","+second + ")"



}

//class Pair2[T: Ordered](val first:T){
// def smaller(implicit ord:Ordered[T]) ={
//  println(ord)
//  if(ord.compare(first) < 0 )first else
// }
// override def toString: String = "("+ first +","+ + ")"
//}
