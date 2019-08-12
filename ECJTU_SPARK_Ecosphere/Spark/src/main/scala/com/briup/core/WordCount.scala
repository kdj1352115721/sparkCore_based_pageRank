package com.briup.core

import org.apache.spark.rdd.{PairRDDFunctions, RDD}
import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
 def main(args: Array[String]): Unit = {
   // 加载sparkconf
//    val conf = new SparkConf().setMaster("local[*]").setAppName("kang_wordCount")
    val conf = new SparkConf().setMaster("local[*]").setAppName("kang_wordCount")
  // 其他的设置是从jar包中去加载

  //sparkContext 上下文环境
  val sc = new SparkContext(conf)

  //获取RDD
   val lines: RDD[String] = sc.textFile("file:///F:/linux_jar/ihaveadream.txt")
//   val lines: RDD[String] = sc.textFile("hdfs://172.16.0.4:9000/Diyo/ihaveadream.txt")
//    new PairRDDFunctions[]()
  // 转化 执行操作
  // flatten不传参的flatMap
  val r1: RDD[String] = lines.flatMap(_.split(" "))
  val r2: RDD[(String, Iterable[String])] = r1.groupBy(x=>x)
  val r3: RDD[(String, Int)] = r2.mapValues(x => x.size)

  // 序列化执行结果
  r3.foreach(println)
  //  本地输入 ：  file:///C:/User/text
  //  hdfs输出 ：  hdfs://172.16.0.4:9000/text
  r3.saveAsTextFile("file:///C:/Users/Administrator/IdeaProjects/ECJTU_SPARK_Ecosphere/Spark/src/main/scala/com/briup/core/wc_result")
//  r3.saveAsTextFile("hdfs://172.16.0.4:9000/kang_wc_result")

  // 关闭sc
  sc.stop()
 }

}
