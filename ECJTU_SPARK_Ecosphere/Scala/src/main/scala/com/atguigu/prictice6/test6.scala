package com.atguigu.prictice6

object test6 extends App {
  // 1
  val time1: Time = new Time(1,2)
  println(time1.before(new Time(2,3)))

  val s: Student = new Student("nike",180)
  println(s.id)

}
// 1
class Time(val hours:Int,val minutes:Int){
  def before(other:Time):Boolean={
        if(this.hours > other.hours){
          println("现在时刻大!")
          return true
        }else{
         println("参数时刻大!")
          return false
        }
  }
}

// 2
class Student(var name:String,val id:Long){

}

//2
import scala.beans.BeanProperty
class Studdent1{
 @BeanProperty var name:String =_
 @BeanProperty var id:Long = _

}