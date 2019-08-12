package com.briup

import org.apache.spark.{SparkConf, SparkContext}

package object ssa {
 def getSCTest(name:String,master:String ="local[*]"):SparkContext ={
  val conf = new SparkConf().setMaster(master).setAppName(name)
  val sc =  SparkContext.getOrCreate(conf)
  sc
 }
}
