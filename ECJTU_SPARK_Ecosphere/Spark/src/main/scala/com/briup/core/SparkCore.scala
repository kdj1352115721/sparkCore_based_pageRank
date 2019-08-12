package com.briup.core

import org.apache.hadoop.io.LongWritable
import org.apache.hadoop.io.Text
import org.apache.hadoop.mapred.KeyValueTextInputFormat
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.util.StatCounter

object SparkCore extends  App {
   val sc: SparkContext = getSC("kd")
   val RDD: RDD[Int] = sc.parallelize(1 to 10)
   val states: StatCounter = RDD.stats()
//   println(states.max)
 //  一个方法可以得到所有数值的操作结果包装的对象
   // countbyValue
 val RDD1: RDD[(Int, Int)] = sc.parallelize(Array((1,1),(1,2),(2,0),(3,6)))
 val a: RDD[(Int, Int)] = RDD1.reduceByKey(_+_)
 val b: collection.Map[(Int, Int), Long] = RDD1.countByValue()
// a.foreach(println)
// println("================")
// b.foreach(println)

 val rdd: RDD[(Int, Long)] = sc.parallelize(10 to 100 by 10).zipWithIndex()
 rdd.foreach(println)

 rdd.saveAsTextFile("Spark/files/kdFile")
 // 读出去的k,v 是什么类型的
// rdd.saveAsHadoopFile("Spark/files/kd_HAdoopFile",classOf[Text],classOf[Text],outputFormatClass =TextOutputFormat[Text,Text])

 //读进来
 def read() ={
  val sc1 = getSC("read")
   // 泛型是读进来下个用什么显示
  val r: RDD[(Int, Long)] = sc1.sequenceFile[Int,Long]("Spark/files/kdFile")
  r.foreach(println)

//  val r1 = sc1.newAPIHadoopFile("Spark/files/kdFile",TextInputFormat,LongWritable,Text)
  val r2 = sc1.newAPIHadoopFile("Spark/files/kdFile")

 }




}
