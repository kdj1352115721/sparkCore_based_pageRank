package com.briup.day3

class Person extends Comparable[Person]{
 // private [包名、类名]限定访问范围，在范围内开放
 // [this]  本类this可用，友元类对象不可用  ，本类对象
 //本类和本类是友缘类
   private [this] var name:String = _
 private  var age:Int = _
   // private(本类)  protected(本类和子类) default(public)
  def this(name:String,age:Int){
   this()
   this.name =name
   this.age =age
  }
// 此处的o是person类的对象，称为友缘类的对象
 override def compareTo(o: Person): Int = {
     return this.age - o.age
 }
}
