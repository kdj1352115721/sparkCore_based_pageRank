package com.briup.core

import org.apache.hadoop.hdfs.server.common.Storage
import org.apache.spark.rdd.RDD
import org.apache.spark.storage.StorageLevel
import org.apache.spark.{SparkConf, SparkContext}

object CreateRDD {
 def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("kd_RDD")
    // 拿sc
    val sc = SparkContext.getOrCreate(conf)
//    val sc = new SparkContext(conf)
   //  通过textFile构建Spark/files/info.txt
  // C:\Users\Administrator\IdeaProjects\ECJTU_SPARK_Ecosphere\Spark\files\info.txt
   val rdd1: RDD[String] = sc.textFile("file:///C:/Users/Administrator/IdeaProjects/ECJTU_SPARK_Ecosphere/Spark/files/info.txt")
//   val rdd2: RDD[String] = sc.textFile("Spark/files/info.txt")
  // 默认分区个数 2   并且数据按原顺序
   // key是文件名，value是整个文件内容
   //具体文件指定到目录
   val rdd3: RDD[(String, String)] = sc.wholeTextFiles("Spark/files")
    // 默认分区个数1
  //通过seq构建RDD
//   val rdd4: RDD[Int] = sc.parallelize( 1 to 10)
   // 默认分区个数4   数据无序输出
  // makeRDD()  构建
//   val rdd5: RDD[Int] = sc.makeRDD(1 to 10)
   // hadoopFIle 输入构建
//   val rdd6: RDD[(Nothing, Nothing)] = sc.newAPIHadoopFile("Spark/files/info.txt")
//    rdd1.foreach(println)
//      rdd1.repartition()
//    rdd2.foreach(println)

    rdd3.foreach(println)

//    rdd4.foreach(println)

//    rdd5.foreach(println)



//   println("1-rdd1 ,rdd 2 ,rdd 3 ,rdd 4 ,rdd 5,rdd6 的 id :"+ rdd1.id+","+rdd2.id+rdd3.id+rdd4.id+rdd5.id+rdd6.id)
  println("---------------------------------")
  println("2----rdd1 的分区列表：")
//  rdd1.partitions.foreach(x=>println(x.index))
  println("---------------------------------")
//  println("rdd1的分区个数: "+rdd1.getNumPartitions)
//  println("rdd2的分区个数: "+rdd2.getNumPartitions)
  println("rdd3的分区个数: "+rdd3.getNumPartitions)
//  println("rdd4的分区个数: "+rdd4.getNumPartitions)
//  println("rdd5的分区个数: "+rdd5.getNumPartitions)


  //缓存
//  val r: rdd1.type = rdd1.persist(StorageLevel.DISK_ONLY)

 }


}
