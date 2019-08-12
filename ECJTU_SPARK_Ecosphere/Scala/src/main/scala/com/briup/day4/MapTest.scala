package com.briup.day4
import scala.collection.mutable
object MapTest extends App {
  // 定义
   //来自predef的map
   val map1: Map[Int, String] = Map((1,"a"),(2,"b"),(3,"c"))

   val map2 = mutable.Map((1,"aa"),(2,"bb"),(3,"cc"))



 //获取数据
  val r1: String = map1.apply(2)
  // Option类  ： 封闭抽象类   在有限个子类（Some,(对象)None），在模式匹配上起作用
  // 值先包裹在Option中
  val r2: String = map1.get(2) match {
   case a:Some[String] => a.get
   case  None => {println("null") ;"null"}

  }
   //  => V1  传名调用
  val r3 = map1.getOrElse(2, () => "c1")
 //遍历
 for(e <- map1){
  println(e._1+":"+e._2)
 }

 for((k,v) <- map1){
  println(k +" "+v)
 }

 for(key  <- map1.keys){
  println(key + " "+map1(key))
 }

 map1.foreach( t1=>{println(t1._1+" "+t1._2)})

// map1.foreach( (k,v)=>{println(k+" "+v)})

 //类中的方法  +  +=  ++  ++=     拉链操作zip  解链unzip  unzip3
 println("-----------------------------------")

 val a1 = Array(1,2,3)
 val a2 = Array("a","b","c","d")

 val z: Array[(Int, String)] = a1.zip(a2)
 val map3: Map[Int, String] =z.toMap
 println(z)
 println(map3)

 // (被连接的集合，第一个集合缺少需要补的值，第二个集合缺少需要补的值)
 val z2: Map[Any, String] = a1.zipAll(a2,"A1","A2").toMap
 println(a1.zipAll(a2,"A1","A2").toMap)

 // unzip3
 val list: List[(Int, String, Int)] = List((1,"a",18),(2,"b",20),(3,"c",38))

 val unzip3: (List[Int], List[String], List[Int]) = list.unzip3
//类似于select id ,name ,age from list
 println(unzip3)



}
