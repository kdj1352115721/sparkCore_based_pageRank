package com.atguigu.prictice7

import com.atguigu.prictice7
import com.atguigu.prictice7.Suits.Value

object Object extends App {
 import Suits._
   val p: Point = Point(3,4)
   val p1: Point =new Point(2,3)
 println("======================")
 //3   app特质中的reverse方法  反转
  println("Hello World".reverse)
 println("======================")
// 4
 println(Suits.Heart)
 println(Suits.isRed(Suits.Spade))
}

// 1
object Conversions{
 def inchesToCentimeters() ={

 }

 def gallonsToLiters ={

 }

 def milesToKilometers() ={

 }
}
//2 伴生类和伴生对象
class Point(i:Int,j:Int){

}

object Point{
 def apply(i: Int, j: Int): Point = new Point(i, j)
}

// 4  枚举需要继承 Enumeration 这个类
object Suits extends Enumeration{
 type Suits = Value
 val Spade: prictice7.Suits.Value = Value("♠")
 val Club: prictice7.Suits.Value = Value("♣")
 val Heart: prictice7.Suits.Value = Value("♥")
 val Diamond: prictice7.Suits.Value = Value("♦")

 override def toString(): String = Suits.values.mkString(",")

 def isRed(card :Suits) ={
    card match {
     case Heart => Heart
     case Diamond => Diamond
     case _ => println("others")
    }
 }


}
