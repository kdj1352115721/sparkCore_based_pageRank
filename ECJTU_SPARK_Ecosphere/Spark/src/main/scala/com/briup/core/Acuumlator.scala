package com.briup.core

import org.apache.spark.util.AccumulatorV2
// 自定义累加器
class MyAcuumlator extends AccumulatorV2[String,String]{

 var str = ""
 override def isZero = if(str.length == 0) true else false

 override def copy() = ???

 override def reset(): Unit = str =""

 override def add(v: String): Unit = str += v

 override def merge(other: AccumulatorV2[String, String]) = {
//  other match {
////   case x :StringAcc => str += x.str
//  }
 }

 override def value = str
}
