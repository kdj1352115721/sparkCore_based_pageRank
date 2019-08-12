package com.briup.day5.Seq
//seq/indexseq/range    (o/c)
import scala.collection.immutable.Range
object RangeTest {
 def main(args: Array[String]): Unit = {

    val r = 1 until(10,2)
    val r2 = 1 to 10 by(2)
    r.+:(5)
    println(r.apply(0))
    println(r)
//   String
   import scala.collection.immutable.StringOps
 }
}
