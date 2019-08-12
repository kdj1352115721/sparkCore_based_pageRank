package com.atguigu.prictice4
import org.junit.Test.None

import scala.collection.mutable.{ArrayBuffer, Map}
object test4 extends App {
  // 1   交换 一个整数的对偶的值
  val map: Map[Int, Int] = Map[Int,Int]((1->11),(2->22),(3->33))
  def swap(map:Map[Int,Int]) ={
    val chageMap = Map[Int,Int]()
    for( elem <- map.keys){
          elem match {
            case  1 =>  chageMap.+=((map.get(1).get,1))
            case  2 =>  chageMap.+=((map.get(2).get,2))
            case  3  =>   chageMap.+=((map.get(3).get,3))
          }
    }
     chageMap
   }
  println(swap(map))
  // 标准 ,匹配一个   元组（）
  def standswap[S,T](tup:(S,T))={
    tup match {
     case (a,b) =>(b,a)
    }
  }
  println(standswap[String,Int]("1",2))

  println("====================================")
   // 2  交换 数组的前两个数字的位置 ,好像可以在不变的数组上改变元素顺序
 import scala.collection.mutable.ArrayBuffer
  def arraySwap(arr:Array[Int])={
         arr match {
          case Array(first,second,rest @_*) => Array(second,first) ++ rest
          case _=> arr
         }
  }
  val arr2 = Array(1,2,3,4)
  val result = arraySwap(arr2).mkString(",")
  println(result)
 println("====================================")

  // 3   不懂
  val special: Bundle = Bundle("Father's day special", 20.0,
   Article("Scala for the Impatient", 39.95),
   Bundle("Anchor Distillery Sampler", 10.0,
    Article("Old Potrero Straight Rye Whiskey", 79.95),
    Article("Junípero Gin", 32.95)))

 def price(it:Item):Double = {
     it match {
      case Article(_,p) => p
      case Bundle(_,disc, its @_*) => its.map(price).sum - disc
     }
 }
  println(price(special))

 // 4 模拟一颗二叉树  计算叶子节点所有元素之和 ,两个参数的递归求和
 println("====================================")
  //  nodesum(a) + nodesum(5) +nodesum(7)  有一个缓存去存储相加的值？ 递归出口是Leaf(v)
  def nodeSum(node:Binarytree):Int={
      node match {
       case Node(a,b) => {println(s"a: $a ,b : $b");nodeSum(a) * nodeSum(b)}
       case Leaf(v) => {println(s"v的值：$v") ; v}
      }
  }
  // 3--5,7
  val r: Binarytree = Node(Leaf(3),Node(Leaf(5),Leaf(7)))
  println(nodeSum(r))
 // 5 模拟一颗树，节点有任意多的后代         一个参数的递归求和
  println("====================================")
  def NodeSum5(node:BinaryTree5):Int={
    node match {
     case Node5(rest @_*) =>  rest.map(NodeSum5 _).sum
     case Leaf5(v) => v
    }
  }
  val node5 = Node5( Node5(Leaf5(3),Leaf5(8)) ,Leaf5(2),  Node5(Leaf5(5)))

  println(NodeSum5(node5))
 // 6
 println("====================================")
  def NodeSum6(node6:BinaryTree6):Int={
   node6 match{
    case Node6(op,leafs @_*) => op match {
      case '+' => leafs.map(NodeSum6).sum
      case '-' => -leafs.map(NodeSum6).sum
      case '*' => leafs.map(NodeSum6).product
    }
    case Leaf6(value) => value
   }
  }

 val x = Node6('+', Node6('*', Leaf6(3), Leaf6(8)), Leaf6(2),  Node6('-', Leaf6(5)))
 println(x)
 println(NodeSum6(x))

  // 7
 println("====================================")
   def fun(list:List[Option[Int]])={
    val sumlist = ArrayBuffer[Int]()
    for(i <- list) {
        i match {
         case a:Some[Int]=> println(s"a :$a") ; sumlist.+=(a.get)
         case c:None => println("none")
        }
    }
    sumlist.sum
   }
  import scala.Option
  val listTest: List[Option[Int]] = List(Some(5),Some(6))
   println(fun(listTest))


















}

// 3
abstract class Item
case class Article(description: String, price: Double) extends Item
case class Bundle(description: String, discount: Double, items: Item*) extends Item

//4
sealed abstract class Binarytree
case class Leaf(value : Int) extends Binarytree
case class Node(left: Binarytree,right: Binarytree) extends Binarytree

//5
sealed abstract class BinaryTree5
case class Leaf5(value:Int) extends BinaryTree5
case class Node5(node5: BinaryTree5 *) extends BinaryTree5

//6
sealed abstract class BinaryTree6
case class Leaf6(value:Int) extends BinaryTree6
case class Node6(op:Char ,node: BinaryTree6 *) extends BinaryTree6