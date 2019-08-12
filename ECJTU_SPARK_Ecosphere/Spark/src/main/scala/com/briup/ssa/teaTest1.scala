package com.briup.ssa

import org.apache.spark.rdd.RDD

object teaTest1 {
 def main(args: Array[String]): Unit = {

   val sc=getSCTest("local[*]")
   //RDD[(文件路径名,文件内容)]
   val files: RDD[(String, String)] =sc.wholeTextFiles("Spark/files/ssa_names");
   //RDD[(文件名,文件内容)]
   val filesInfo: RDD[(String, String)] =files.map(x=>(x._1.substring(x._1.lastIndexOf("/")+1,x._1.length),x._2));
//   filesInfo.foreach(x => println(x._2))

   val genderAndNum: RDD[(String, Array[(String, Int)])] = filesInfo.mapValues(line=>{
    //line 为每年的出生信息,代表是RDD中value  name，gender,number  \n name,gender,number .......
    val arr: Array[String] =line.split("\n")
     arr.map(x => {
     val a = x.split(",")
     (a(1), a(2).trim.toInt)
    })
//    val a: Array[Array[String]] = arr.map(x => x.split(","))
//     关键
//    val text1: Array[(String, Int)] = arr.map(x =>  {val a = x.split(",") ;(a.apply(1),a.apply(2).trim.toInt)})

   })
   // 将String不变， gender和Nums整合到一起
  //  （年份，《性别，数量》）

   import scala.collection.mutable
   val result: RDD[(String, mutable.Map[String, Int])] =genderAndNum.mapValues(arr=>{
    arr.aggregate(mutable.Map.empty[String,Int])((init:mutable.Map[String,Int], v:(String,Int))=>{
     val data =init.getOrElse(v._1,0)
     init.put(v._1,v._2+data)
     init
    },
    (v1:mutable.Map[String,Int],v2:mutable.Map[String,Int])=>{
     v1.foreach(x=>{
      val data =v2.getOrElse(x._1,0)
      v2.put(x._1,x._2+data)
     })
     v2
    }
    )

   })
//   result.take(10).foreach(println)


 }

}
