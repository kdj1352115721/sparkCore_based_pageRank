package com.briup.sql

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.types.{DataType, StructField, StructType, _}
import org.apache.spark.sql.{DataFrame, Row, SparkSession, types}

import scala.collection.immutable

object DFAandDSTest extends  App {
    val sparkSession: SparkSession = getSpark("spark")

    import sparkSession.implicits._
    //   1    通过read 读取外部数据源
    val df: DataFrame = sparkSession.read.csv("Spark/files/topic.txt")
    df.show()
   println("==================")

   // 2
   val sparkSession1 = getSpark("spark1")
   import sparkSession1.implicits._
   val seq: Seq[Person] = Seq(Person("alias",20),Person("bob",24))
   // 因为是上下文鉴定， 传入的参数必需是Product的子类   元组或样例类
   val df1: DataFrame = sparkSession1.createDataFrame(seq)
   df1.show()

 // 3
 println("==================")
 val sparkSession2 = getSpark("spark3")
 import sparkSession2.implicits._
 val seq1: Seq[Row] = Seq(Row("jack",20),Row("terry",25))
 val sc: SparkContext =  getSC("sc")
 val RDD: RDD[Row] =  sc.parallelize(seq1)

 val s_f: Seq[StructField] = Seq(
  StructField("name1",StringType),
   StructField("age1",IntegerType)
 ) // 指明字段的段名
 val schema: StructType = StructType(s_f)

 val sf: DataFrame = sparkSession2.createDataFrame(RDD,schema)
 // 通过将RDataFrame 装换成二维表形式
 val person: Unit = sf.createOrReplaceTempView("person")
  // 通过sql语句来执行操作
 sparkSession2.sql("select * from person where age1 > 22").show()


 println("=========================")

 val spark4: SparkSession = getSpark("Spark4")




}

case class Person(name:String,age: Int){


}