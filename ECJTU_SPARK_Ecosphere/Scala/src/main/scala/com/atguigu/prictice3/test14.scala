package com.atguigu.prictice3

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object test14 extends App {

 // 10
 val arr  = Array(1,2,3,45,4)
 def minmax(values : Array[Int]):(Int,Int) = {
  val min = values.min
  val max = values.max
  val tuple: (Int, Int) = (min,max)
  tuple
 }
 println(minmax(arr))
 println("=========================")

 // 11
 val s: String = "Mississppi"
 val r: mutable.HashMap[Char, mutable.SortedSet[Int]] = indexes(s)
 println(r)

 def indexes(s:String):mutable.HashMap[Char,mutable.SortedSet[Int]] = {
  var map = new mutable.HashMap[Char, mutable.SortedSet[Int]]()
  var i = 0
  s.foreach {
   elem =>
    map.get(elem) match {
     //暂无值
     case None => map += (elem -> mutable.SortedSet(i))
     // 有值
     case Some(result) => map(elem) = result.+(i)

    }
    i += 1  // 遍历一次  i+1
  }
  map
 }
 println("=================")
 // 12  12.1
 val list: List[Int] =  List(1,23,4,5,0,3,6,0)
 def except0(list:List[Int]) ={
  val queue: mutable.Queue[Int] = new mutable.Queue[Int]()
  list.foreach { elem => elem match {
   case 0 => println("0")
   case x => println("other"); queue.+=(x)
  }
  }
  val list1: List[Int] = queue.toList
  list1
 }
 val list2: List[Int] = except0(list)
 println(list2)
 // 12.2
 def except01(list:List[Int]) ={
  val listBuffer = new ListBuffer[Int]
  list.foreach{
   elem => elem match {
    case 0 => println("0")
    case x => listBuffer.+=(x)
   }
  }
  listBuffer
 }
 println(except01(list))
 // 12.3
 def remove0(list:List[Int]) ={
  val list3: List[Int] = list.filter(elem => elem.!=(0))
  list3
 }
 println(remove0(list))

 println("=========================")

 //13
 import scala.collection.immutable.Map
 val arr13 = Array("Tom","Bob","Chris")
 val map13 = Map("Tom" ->5,"Bob" -> 6,"Dick"->81)
 def flat(arr:Array[String],map:Map[String,Int])={
  import scala.collection.mutable.ArrayBuffer
  val ab13 = new ArrayBuffer[Int]()
  for( elem <- arr13 ){
   map.get(elem) match {
    case Some(result) => ab13.+=(result)
    case None => println("None")
   }
  }
  ab13
 }
 val result13 = flat(arr13,map13).mkString(",")
 println("result:"+result13)

 //13 .1
 def strMap(strArr:Array[String],map:Map[String,Int]):Array[Int] ={
  strArr.flatMap(map.get(_))
 }
 val arr131 = Array("Tom","Bob","Chris")
 val map131: Map[String, Int] = Map("Tom" ->5,"Bob" -> 6,"Dick"->81)
 val result: String = strMap(arr131,map131).mkString(",")
 println("result:"+result)
 // 14
 def mymakeString(set: Set[String],s:String): String ={
  val s1: String = set.reduceLeft(_+s+_)
  s1
 }
 val set: Set[String] = Set("1","2","3")
 // val set1: String = set.mkString("and")
 // println(set1)
 println(mymakeString(set,"and"))

 println("=========================")

 //15  需要问老师
 val list15: List[Int] = List(1,2,3,4,5)
 val result15: List[Int] = (list15 :\ List[Int]())(_::_)

 val result15_2 = (list15 :\ List[Int]())((x,y)=>{y :+ x})
  //     集合 /:  数值   ====> (集合x ,数值 y ） => { x :+ y } 正向输出
  //   集合 /:  数值   ====> (集合x ,数值 y ） => { y +: x } 反向输出
  val result15_3 = (List[Int]() /: list15)((x,y)=>{y +:x})
 val result15_4 = (List[Int]() :\ list15)((x,y)=>{x +: y })
 println(result15)
 println(result15_2)
 println(result15_3)
 println(result15_4)


 // 16  array.grouped(i).toArray   按i分成几个组,再转成Array
 println("==========================")
  def divArr(arr:Array[Int],i:Int) ={
   arr.grouped(i).toArray
  }
 val arr16 = Array(1,2,3,4,5,6,7)
 val arr161: Array[Array[Int]] = divArr(arr16,3)
 arr161.foreach(elem => println(elem.mkString(",")))

 //17
 //   单词统计
 //   单线程的 ，多线程的
 println("==========================")
 import scala.collection.mutable.SortedMap
 def WordCount(s:String) ={
  val map: mutable.SortedMap[Char, Int] = SortedMap[Char,Int]()
  for(elem  <- s){
     map(elem) = (map.getOrElse(elem,0) + 1)
  }
  map
 }
  val map17: mutable.SortedMap[Char, Int] = WordCount("ihaveadream")
  println(map17)


 // 待看
  val str17 = "ihaveadream"
  val parWordCount: Map[Char, Int] = str17.par.aggregate(Map[Char,Int]())(
   { (a,b) => a+ (b -> (a.getOrElse(b,0)+1))},
   {(map1,map2) => (map1.keySet ++ map2.keySet).foldLeft(Map[Char,Int]()){
           // fold
         (result,k) => result +(k -> (map1.getOrElse(k,0) +map2.getOrElse(k,0) ))
       }
   }
  )
  println(parWordCount)


}

