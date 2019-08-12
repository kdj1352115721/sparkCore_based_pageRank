package com.briup.core

import java.sql.DriverManager

import org.apache.spark.rdd.RDD
import org.apache.spark.util.LongAccumulator
import org.junit.Test

class MovieRDDTest{
//   //统计看电影的男女比例，并存入mysql数据库
////  @Test
////  def first():Unit ={
////      val sc =getSC("first_kd")
////      val users: RDD[String] = sc.textFile("hdfs://172.16.0.4:9000/data/grouplens/ml-1m/users.dat")
////      //  1. 先计算男女用户个数，再除最大公约数
//////      val r: RDD[(Char, Iterable[Char])] = users.flatMap(_.split("::")(1)).groupBy(x => x)
//////      val r2: RDD[(Char, Int)] = r.mapValues(ite => ite.size)  //将 r中的value进行映射  ，  将interator映射成 iter.size
////
////      // 2. 没有迭代器的参与，更加高效，不耗资源
//////      val r3: RDD[(String, Int)] = users.map(x =>  (x.split("::")(1),1) )
//////      val r4: RDD[(String, Int)] = r3.reduceByKey(_+_)
////      val r1: RDD[(String, Int)] = users.map(x => (x.split("::")(1) ,1)).reduceByKey(_+_)
////      var f_num = r1("F")
////      var m_num = r1("M")
////      var g = gcd(f_num,m_num)
////
////
////
////
//////      r1.foreach(x =>{
//////         // x 是元组 （F,1）
//////         val url = " "
//////       val driver = " "
//////       val user = " "
//////       val passwd = " "
//////       Class.forName(driver)
//////       val conn = DriverManager.getConnection(url,user,passwd)
//////       val sql = "insert into movie_user values (?,?)"
//////       val prep = conn.prepareStatement(sql)
//////         prep.setString(1,x._1)
//////         prep.setLong(2,x._2)
//////         prep.execute()
//////       prep.close()
//////       conn.close()
//////      })
////
//////      r1.foreachPartition(ite => ite.foreach(x =>{
//////        // x 是每一行  ，
//////              val url = " "
//////              val driver = " "
//////              val user = " "
//////              val passwd = " "
//////              Class.forName(driver)
//////              val conn = DriverManager.getConnection(url,user,passwd)
//////              val sql = "insert into movie_user values (?,?)"
//////              val prep = conn.prepareStatement(sql)
//////                prep.setString(1,x._1)
//////                prep.setLong(2,x._2)
//////                prep.execute()
//////              prep.close()
//////              conn.close()
//////
//////      }
//////      ))
////
////      r1.foreachPartition{
////       val url = " "
////       val driver = " "
////       val user = " "
////       val passwd = " "
////       Class.forName(driver)
////       val conn = DriverManager.getConnection(url,user,passwd)
////       val sql = "insert into movie_user values (?,?)"
////       val prep = conn.prepareStatement(sql)
////       ite => ite.foreach(x =>{
////        //重资源放置在循环体内，有几个分区有几次循环，而不是一行一个循环
////       // x 是每一行  ，
////       prep.setString(1,x._1)
////       prep.setLong(2,x._2)
////       prep.execute()
////      }
////      )
////        prep.close()
////        conn.close()
////      }
////
////
////
////   // 求最大公约数：
////    def gcd(x:Long,y:Long):Long={
////       var temp = x % y
////       if(temp == 0){
////          temp = y
////       }else{
////          gcd(y,temp)
////       }
////       temp
////    }
////
////
////
////   // 3.
////   val r4: collection.Map[Char, Long] = users.flatMap(x => x.split("::")(1)).countByValue()
////      //有隐患，在driver端进行的Count
////
////
////
////  }
//
//   // 统计文件中单词个数，并统计空行个数
////  @Test
////  def second():Unit={
////   val sc = getSC("second_kd")
////   val r = sc.textFile("files/info.txt")
//////   var blanknums = 0;
////   var blanknums: LongAccumulator = sc.longAccumulator("blanknums")
////   // 使用累加器，闭包中所使用的局部变量，会序列化，发送到worker
////   // 但是不会把值返回给dreiver
////   // 如果在闭包函数，做数字累加，使用累加器可以将变量在excuotor
////   val word: RDD[(String, Int)] = r.flatMap(x => {
////   if(x == ""){
////    blanknums.add(1)
////   }else{
////     x.split(" ")
////   }
////    x.split(" ")
////   }).groupBy(x=>x).mapValues(ite => ite.size)
////
////   word.foreach(println)
////   println("空行个数："+blanknums.value)
////
////   sc.stop()
////   @Test
////   def second():Unit={
////    val sc = getSC("second_kd")
////    val r = sc.textFile("files/info.txt")
////    var blanknums = 0;
////    val word: collection.Map[String, Long] = r.flatMap(x => {
////     if(x == ""){
////      blanknums += 1
////     }else{
////      x.split(" ")
////     }
////     x.split(" ")
////    }).countByValue()
//
//  }


}
