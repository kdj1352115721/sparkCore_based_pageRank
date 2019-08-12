package com.briup.day7

object Object extends App {

 val a = new Ant
 //请问此处数组多长？？？
 println(a.env.length)

}
class Creature {
 val range : Int=10
   val env: Array[Int] = new Array[Int] ( range)
// lazy  val env: Array[Int] = new Array[Int] ( range)
//   懒加载，没有缓存
 // 此处range是调用子类的方法getRange()  初始化父类时调用了子类未初始化的属性。
}

// 提前定义
class Ant extends { override val range=2 }with Creature {

}