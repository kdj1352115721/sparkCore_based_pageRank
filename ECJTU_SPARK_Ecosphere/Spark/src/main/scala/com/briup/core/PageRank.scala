package com.briup.core

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

import scala.collection.immutable


object PageRank extends App {

 val sc: SparkContext = getSC("test2_kd")
 //   val files: RDD[(Text, Text)] = sc.newAPIHadoopFile[Text,Text,KeyValueTextInputFormat[Text,Text]]("hdfs://172.16.0.4/data/spark/pageRank")
 val file2: RDD[String] = sc.textFile("hdfs://172.16.0.4:9000/data/spark/pageRank/graphx-wiki-vertices.txt")
 val file: RDD[String] = sc.textFile("hdfs://172.16.0.4:9000/data/spark/pageRank/graphx-wiki-edges.txt")

 //  one  拿到原始两个数据集

 // page 初始权重
 val pageAndWeight: RDD[(String, Double)] = file2.map(x => {
  val Array(page, _) = x.split("\t")
  (page, 1.0)
 }

 )
 // page  outlinkpage
 val pageAndOut: RDD[(String, String)] = file.map(x => {
  val Array(page, ol) = x.split("\t")
  (page, ol)
 }
 )

 // second  step
 val pageAndOuts: RDD[(String, Iterable[String])] = pageAndOut.groupByKey()

 // third step  将相同的key 的value值，两两组成一个元组形式
 val join: RDD[(String, (Double, Iterable[String]))] = pageAndWeight.join(pageAndOuts)
 //  join.foreach(println)
 // (2135172135140341737,(1.0,CompactBuffer(1164897641584173425)))
 // (4126850520308413873,(1.0,CompactBuffer(1735121673437871410, 1841741719511399282)))
 // (6874845074540610780,(1.0,CompactBuffer(3961392555585273859, 4312043494315800855)))
 val a: immutable.Seq[RDD[(String, Double)]] = 1 to 50 map (
  temp => {
  // fourth step
  val olAndRank: RDD[(String, Double)] = join.flatMap(x => {
   x._2._2.map(m => {
    val a: (String, Double) = (m, 1.0 / m.size)
    a
   })
  })
  // step 5
  val olAndRanks: RDD[(String, Double)] = olAndRank.reduceByKey(_ + _)
  // step 6
  val final_once: RDD[(String, Double)] = olAndRanks.mapValues(_ * 0.85 + 0.15)
   final_once
 })

 a.foreach(x =>x.foreach(y => println(y)) )

 // val a: RDD[(String, Iterable[Double])] = olAndRank.groupByKey()
 // (168544935916381549,CompactBuffer(0.05555555555555555, 0.05555555555555555))
 // (4899548256233128787,CompactBuffer(0.05263157894736842))
 // (85787172984349021,CompactBuffer(0.058823529411764705, 0.058823529411764705))
 // (1814357170868556097,CompactBuffer(0.05263157894736842))
 // (7619157718950404551,CompactBuffer(0.05263157894736842))


}
