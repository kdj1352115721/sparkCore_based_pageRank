package com.briup.day2

object CollectionsTest extends App {
// // 数组(同一类型元素) ,对象创建
//  val arr: Array[Int] = Array(1,2,3,4)
//  arr.foreach(println)
//  println(arr.apply(2))
// //赋值
// arr(0) =5
// //取值
// val r1: Int = arr.apply(0)
// val r: Array[Int] = arr.takeRight(2)
 // arr.takeWhile()
 //遍历：
//  arr.foreach(println)
/* println("================")
  for(i <- 0 to arr.length -1){
    println(arr(i))
  }
 println("===========")
 println(arr.size)*/
 //  arrayBuffer*/
  //可变数组ArrayBuffer
// import scala.collection.mutable.ArrayBuffer
// val  ab1 = new ArrayBuffer[Int](3)
//
// val ab2 = ArrayBuffer(1,3,2,4,5)

 //添加元素
//  val ab3: ArrayBuffer[Int] = ab2.+:(6)
//  val ab4: ArrayBuffer[Int] = ab3.:+(7)
//  val ab5: ab4.type = ab4.+=(8)
//  val ab6: ab5.type = ab5.++=(ab3)
//  val ab7: ab6.type = ab6.+=:(9)
//  val ab8: ArrayBuffer[Int] = ab7.++:(ab2)
/*  val a: Unit = ab2.insert(1,5,5,6) // 按下表插入一或多值
  val b: Unit =ab2.append(9,9,9) //末尾增加多个值*/

//  println(ab2)
 //删除元素
// val ab3: ArrayBuffer[Int] = ab2.-(9)   //寻找特定值去删除 ，返回新的数组

// ab2.-=(9)  // 原数组减去特定值

/* val a1: Int = ab2.remove(3)   //减去下标对应的值
val a2: Unit =    ab2.remove(3,1)   //从下标下一位开始减去几位,不能超过length
   val ab3: ArrayBuffer[Int] = ab2.drop(2)
   val ab4: ArrayBuffer[Int] = ab2.dropRight(2)*/
//   val ab3: ArrayBuffer[Int] =ab2.take(2)
//   val ab3: ArrayBuffer[Int] =ab2.sorted
//     val ab3: ArrayBuffer[Int] = for(elem <- ab2 if (elem % 2 ==0 )) yield elem*2
//    val ab3: ArrayBuffer[Int] =  ab2.filter(_%2 ==0).map(_*2)
//   val ab3: ArrayBuffer[Int] = ab2.filter(elem => elem%2 ==0).map(elem=>elem*2)

// println(ab3)
 //改
 //遍历
 //多维数组：
// val arr2 = new Array[Array[Int]](3)
// arr2(0) = Array(1,2,3)
// arr2(1) = Array(4,5)
// for(i <- arr2){
//  i.foreach(elem => println(elem))

// }




  //list
  val list: Seq[Int] = List(1,2,3,4)
 //set
  val set: Set[Int] = Set(1,2,3,4)
 //map
  val map: Map[Int, String] = Map((1,"String"),(2,"String2"))
 //tuple2  对象创建
 val tuple: (Int, Int) = Tuple2(1,2)

// println(tuple._1)
 val (name,age,phone,adress) = ("alias",18,130,"上海")

// println(name)
 //返回一个二元组
// val t: (String, String) = "New York".partition(_.isUpper)
 val x,y,z  = (1,"hello",2)
 println(y)

}


