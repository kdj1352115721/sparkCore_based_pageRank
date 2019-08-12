package com.briup.ssa

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object test1 {
 def main(args: Array[String]): Unit = {
  //  分析任务：
  //  1、130年中每年出生婴儿的男女比例
  //   2、出生婴儿男女比例最失调的N个年份
  //  3、名字叫做John,Harry,Mary,Marilyn婴儿的出生趋势
  //  4、按性别计算每年最常用的1000个名字人数占当年总出生人数的比例（名字多样化分析）
  //  5、按性别假定每年有频率最高的前N个名字(N最小)的婴儿人数总和超过当年该性别总人数的50%，N值随年份的变化趋势。（名字多样化分析）
  //  6、各年出生的男孩名字以d/n/y结尾的人数占当年的比例
  //  7、130年中，变化趋势最明显的前n个名字(可以考虑使用标准差度量)
  val sc: SparkContext = getSCTest("test1_kd")
  //  读取目录
  val files: RDD[(String, String)] = sc.wholeTextFiles("Spark/files/ssa_names")
  // 把pair的键变化，值不变
  val filenames: RDD[(String, String)] = files.map(x => (x._1.substring(x._1.length - 8, x._1.length),x._2))
 //想拿到 2004,值不变
  val file: RDD[(String, String)] = filenames.map(x =>( x._1.substring(0,4)+"年",x._2))
//  拿到 key  1996年:
//=================================================================
   //  拿 内容 中的     性别 ，数量
/*  val word: RDD[Array[String]] = texts.map(x => x.split(","))
//  拿到 Jerrie F 21     [Ljava.lang.String;@1aaef530 一个对象代表就是 Jerrie F 21
  val gender: RDD[String] = word.map(x =>x.apply(1))
  // 拿到 F F F 。。。。。所有的性别
  val nums: RDD[Int] = word.map(_.apply(2)).map(x =>x.trim.toInt)
  // 拿到所有的当年出生数量   10 10 10 。。。。。。
  // 需要将 Key  性别    value nums 出生数量
  val RDD1: RDD[(String, Int)] = gender.zip(nums)*/

  //操作pairRDD，将整合成一个（年份，Array((gender,numbers))元组 ）  形式
  // 使用mapvalues key 不变， 执行values操作
  val year_gender_number: RDD[(String, Array[(String, Int)])] = file.mapValues(x =>{
   val a: Array[String] = x.split("\n")
   // 如果a这个map里后面的返回值不是以这种元组形式存在，arr返回值就会是又被切分后形成的Array包括，外层本来就有一层Array，就形成了Array（Array（））
   val arr: Array[(String, Int)] = a.map(x => {val b = x.split(","); (b.apply(1),b.apply(2).trim.toInt ) })
   arr
   } )

   // 需要将 key ,value 构建成一个pairRDD
  val result: RDD[(String, mutable.Map[String, Int])] = year_gender_number.mapValues { arr =>
   import scala.collection.mutable
   var map: mutable.Map[String, Int] = mutable.Map.empty
   def seqOp(map: mutable.Map[String,Int],a:(String,Int)) = {
    // 将本分区的map计数
       map.+=((a._1,map.getOrElse(a._1,0)+a._2))
       map
   }
  def combOp(map1:mutable.Map[String,Int],map2:mutable.Map[String,Int])= {
     // 将各个分区的map聚合
      map1.foreach( x => {
       map.+=((x._1,x._2+map2.getOrElse(x._1,0) ))
       map
      }
      )
      map
   }

   arr.aggregate(map)(seqOp,combOp)
 }


 result.take(10).foreach(println)
// 所有的男女比例 (M,162412587)
//                (F,159990140)
//  (1880年,Map(M -> 110493, F -> 90993))
//  (1881年,Map(M -> 100748, F -> 91955))
//  (1882年,Map(M -> 113687, F -> 107851))
//  (1883年,Map(M -> 104632, F -> 112322))
//  (1884年,Map(M -> 114445, F -> 129021))
//  (1885年,Map(M -> 107802, F -> 133056))
//  (1886年,Map(M -> 110785, F -> 144538))
//  (1887年,Map(M -> 101412, F -> 145983))
//  (1888年,Map(M -> 120857, F -> 178631))
//  (1889年,Map(M -> 110590, F -> 178369))




 }
}
