package com.atguigu.prictice8

object PackageTest {
 def main(args: Array[String]): Unit = {
    // 2  包和引入

    import java.util.{HashMap => javaHashMap}
    import collection.mutable.{HashMap => ScalaHashMap,Map => ScalaMap}
     // 包的引入以及改名

    val javaMap = new javaHashMap[Int,String]()
    javaMap.put(1,"alias")
    javaMap.put(2,"bob")

    val scalaMap = new ScalaHashMap[Int,String]()
    for( key <- javaMap.keySet().toArray){
       scalaMap += (key.asInstanceOf[Int] -> javaMap.get(key))

    }
   println(scalaMap.mkString(","))




 }
}
