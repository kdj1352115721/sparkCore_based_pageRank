package com.briup.day4

import com.briup.day6
import com.briup.day6.Acount

import scala.collection.mutable.ArrayBuffer
//类似于comparable （内部比较）  自然排序，让元素具有比较的特性
class Student(var name:String,var age:Int,var score:Double) extends Ordered[Student]{


 override def toString: String = "Student:"+name+" "+"age:"+" "+age+" "+"score:"+score


 override def compare(that: Student): Int = {
//    if(this.age > that.age){
//     return 1
//    }else if(this.age < that.age){
//     return -1  //不变                   //  this.age -that.age < 0 不变  升序  this.age - that.age
//    }else{
//     return 0
//    }
//     if(this.age > that.age){              // this.age - that.age >0 不变  降序  that.age-this.age
//      return  -1
//     }else if(this.age < that.age){
//      return  1
//     }else{
//      return 0
//     }
    that.age -this.age
 }

}
 //
object Student  {
  def main(args: Array[String]): Unit = {

  }
 val s1 = new Student("alias",18,18.2)
 val s2 = new Student("bob",20,193.6)
 val s3 = new Student("chris",23,128.6)
 val s4 = new Student("didi",29,18.52)
 val s5 = new Student("ella",15,16.2)
 val ab = ArrayBuffer[Student](s1,s2,s3,s4,s5)
 ab.foreach(println)
 println("==============")
 val ab2: ArrayBuffer[Student] =ab.sorted
 ab2.foreach(println)




}
  //传比较器 ，sortedby（（）=>{}） 参数是Map取出需要比较的东西
  object StudentOrdering extends Ordering[Student]{
   def main(args: Array[String]): Unit = {

   }
   val s1 = new Student("alias",18,18.3)
   val s2 = new Student("bob",20,18.2)
   val s3 = new Student("chris",23,181)
   val s4 = new Student("didi",29,18.8)
   val s5 = new Student("ella",15,18.3)
   val ab = ArrayBuffer[Student](s1,s2,s3,s4,s5)

  implicit override def compare(x: Student, y: Student): Int = {
   (x.score -y.score).toInt
   }
   println(ab)
   println("--------------")
   println("-----------------")

   val ab2 = ab.sortBy(s=>s)
   println(ab2)



 }


