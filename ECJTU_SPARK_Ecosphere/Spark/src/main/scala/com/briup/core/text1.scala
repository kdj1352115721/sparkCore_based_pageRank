package com.briup.core

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

object text1 extends App {

   //计算每个用户的平均评分，取分数最高10个 ，分数最低的10个
    val sc: SparkContext = getSC("text1_kd")
    val rating: RDD[String] = sc.textFile("Spark/files/rating")
    val user_score: RDD[(String, Double)] = rating.map{ x =>
     val Array(_,userid,score,_)= x.split("::")
     (userid,score.toDouble)
    }
    //  (userid ,socre)  ====> (userid, iterator[socre])=============> (userid,avgScore)
    val scoreAvg: RDD[(String, Double)] = user_score.groupByKey().mapValues{ x =>
     val list: List[Double] = x.toList
     list.sum/list.size
    }
//    scoreAvg.map{
//     case (x,y) => (y,x)    // 转化位置
//    }.top(10).foreach(println)

   val scoreAvg1: RDD[(String, Double)] =  user_score.combineByKey[(Double,Long)](createCombiner _,mergeValue _,mergeCombiner _).mapValues(x => x._1/x._2)
    def createCombiner(d:Double)={
           (d,1L)
    }
    def mergeValue(a:(Double,Long),d:Double) ={
     (a._1+d,a._2+1L)
    }
   def mergeCombiner(a:(Double,Long),b:(Double,Long)) ={
    (a._1+b._1,a._2+b._2)
   }

   scoreAvg1.foreach(println)



}
