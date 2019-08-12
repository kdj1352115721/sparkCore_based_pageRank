/*
package com.briup.SSA

import com.briup
import org.apache.spark.rdd.RDD
import org.junit.Test

import scala.collection.{immutable, mutable}

/**
  * 数据目录：hdfs://172.16.0.4/data/ssa_names
  **
  *数据说明：
  *SSA(美国社会保障属)整理了从1880到2010年的婴儿名字频率数据，该数据集按年份分割成若干文件，每个文件名包含年份，文件内容如下：
  *姓名,性别,当年出生人数
  **
  *分析任务：
  *1、130年中每年出生婴儿的男女比例
  *2、出生婴儿男女比例最失调的N个年份
  *3、名字叫做John,Harry,Mary,Marilyn婴儿的出生趋势
  *4、按性别计算每年最常用的1000个名字人数占当年总出生人数的比例（名字多样化分析）
  *5、按性别假定每年有频率最高的前N个名字(N最小)的婴儿人数总和超过当年该性别总人数的50%，N值随年份的变化趋势。（名字多样化分析）
  *6、各年出生的男孩名字以d/n/y结尾的人数占当年的比例
  *7、130年中，变化趋势最明显的前n个名字(可以考虑使用标准差度量)
  **
  *要求：
*在spark中，交互分析完成上述问题（问题顺序可自行调整）
  *
 * */
class BabyRDDTest {

  /**
    * 1、130年中每年出生婴儿的男女比例
    * */
  @Test
  def first()={
    val sc=briup.getSparkContext("local[*]","movie_spark");
    //RDD[(文件路径名,文件内容)]
    val files: RDD[(String, String)] =sc.wholeTextFiles("/Users/angelia/IdeaProjects/BD1803/spark/baby/yob*");
    //RDD[(文件名,文件内容)]
    val filesInfo=files.map(x=>(x._1.substring(x._1.lastIndexOf("/")+1,x._1.length),x._2));
    val genderAndNum=filesInfo.mapValues(line=>{
      //line 为每年的出生信息
      val arr=line.split("\n");
      val info= {
        arr.map(x => {
          val a = x.split(",");
         (a(1), a(2).trim.toInt);
        })
      };
      info
    });
    val result =genderAndNum.mapValues(arr=>{
      //arr.groupBy(_._1).mapValues(arr=>{arr.ag})
      arr.aggregate(mutable.Map.empty[String,Int])((init:mutable.Map[String,Int], v:(String,Int))=>{
        val data =init.getOrElse(v._1,0);
        init.put(v._1,v._2+data)
        init
      },(v1:mutable.Map[String,Int],v2:mutable.Map[String,Int])=>{
        v1.foreach(x=>{
          val data =v2.getOrElse(x._1,0);
          v2.put(x._1,x._2+data)
        })
        v2
      }
      )
    })
//      .mapValues(map=>{
//      val fmale=map.getOrElse("F",0);
//      val male=map.getOrElse("M",0);
//      val minNum=scala.math.min(fmale,male);
//      import util.control.Breaks._
//
//        var boy=fmale;
//        var gril=male;
//      breakable {
//        val info = minNum.to(1, -1).map(x => {
//          if ((fmale % x == 0) && (male % x == 0)) {
//            boy = (fmale / x)
//            gril = (male / x)
//            break();
//          }
//        })
//      }
//      (boy,gril)
//
//    })
    result.take(10).foreach(println)
  }

  /**
    * 2、出生婴儿男女比例最失调的N个年份
    * */
  @Test
  def second()={
    val sc=briup.getSparkContext("local[*]","movie_spark");
    //RDD[(文件路径名,文件内容)]
    val files: RDD[(String, String)] =sc.wholeTextFiles("/Users/angelia/IdeaProjects/BD1803/spark/baby/yob*");
    //RDD[(文件名,文件内容)]
    val filesInfo=files.map(x=>(x._1.substring(x._1.lastIndexOf("/")+1,x._1.length),x._2));
    val genderAndNum=filesInfo.mapValues(line=>{
      //line 为每年的出生信息
      val arr=line.split("\n");
      val info= {
        arr.map(x => {
          val a = x.split(",");
          (a(1), a(2).trim.toInt);
        })
      };
      info
    });
    val result =genderAndNum.mapValues(arr=>{
      //arr.groupBy(_._1).mapValues(arr=>{arr.ag})
      arr.aggregate(mutable.Map.empty[String,Int])((init:mutable.Map[String,Int], v:(String,Int))=>{
        val data =init.getOrElse(v._1,0);
        init.put(v._1,v._2+data)
        init
      },(v1:mutable.Map[String,Int],v2:mutable.Map[String,Int])=>{
        v1.foreach(x=>{
          val data =v2.getOrElse(x._1,0);
          v2.put(x._1,x._2+data)
        })
        v2
      }
      )
    })
          .mapValues(map=>{
          val fmale=map.getOrElse("F",0);
          val male=map.getOrElse("M",0);
          val minNum=scala.math.min(fmale,male);
          import util.control.Breaks._

            var boy=male;
            var gril=fmale;
          breakable {
            val info = minNum.to(1, -1).map(x => {
              if ((fmale % x == 0) && (male % x == 0)) {
                boy = (fmale / x)
                gril = (male / x)
                break();
              }
            })
          }
//          (boy,gril);
            scala.math.max(boy,gril).toDouble/ scala.math.min(boy,gril).toDouble
        })
    result.sortBy(_._2,false).take(10).foreach(println)
  }

  /**
    * 3、名字叫做John,Harry,Mary,Marilyn婴儿的出生趋势
    * */
  @Test
  def three()={
    val sc=briup.getSparkContext("local[*]","movie_spark");
    //RDD[(文件路径名,文件内容)]
    val files: RDD[(String, String)] =sc.wholeTextFiles("/Users/angelia/IdeaProjects/BD1803/spark/baby/yob*");
    //RDD[(文件名,文件内容)]
    val filesInfo=files.map(x=>(x._1.substring(x._1.lastIndexOf("/")+1,x._1.length),x._2));
    val nameAndYearAndNum=filesInfo.flatMap(line=>{
      //line 为每年的出生信息
      val arr=line._2.split("\n");
      val info= {
        arr.filter(x=>x.contains("John,")||x.contains("Harry,")||x.contains("Mary,")||x.contains("Marilyn,")).map(x => {
          val a = x.split(",");
          ((a(0),line._1),a(2).trim.toInt);
        })
      };
      info
    });
    nameAndYearAndNum.sortByKey(true).foreach(println)
  }

  /**
    * 4、按性别计算每年最常用的1000个名字人数占当年总出生人数的比例（名字多样化分析）
    * */
  @Test
  def four()={
    val sc=briup.getSparkContext("local[*]","movie_spark");
    //RDD[(文件路径名,文件内容)]
    val files: RDD[(String, String)] =sc.wholeTextFiles("/Users/angelia/IdeaProjects/BD1803/spark/baby/yob*");
    //RDD[(文件名,文件内容)]
    val filesInfo=files.map(x=>(x._1.substring(x._1.lastIndexOf("/")+1,x._1.length),x._2));
    val yearAndGenderAndNameAndNum=filesInfo.flatMap(line=>{
      //line 为每年的出生信息
      val arr=line._2.split("\n");
      var maleTotal=0;
      var fmaleTotal=0;
      val info= {
        arr.map(x => {
          val a = x.split(",");
          val num=a(2).trim.toInt;
          a(1) match {
            case "M" =>
              maleTotal+=num;
            case _ =>
              fmaleTotal+=num;
          }
          //年份 性别 名字 人数
          ((line._1,a(1)),(a(0),num));
        })
      }.map(x=>{
        x._1._2 match {
          case "F" =>
            (x._1,(x._2,fmaleTotal))
          case _ =>
            (x._1,(x._2,maleTotal))
        }
      });
      info
    });
    yearAndGenderAndNameAndNum.
      groupByKey().mapValues(iter=>{
      iter.toList.sortBy(_._2)(Ordering[Int].reverse).take(1000).map(x=>(x._1._1,x._1._2.toDouble/x._2.toDouble))
    }).sortByKey().foreach(println)

  }

  /**
    *5、按性别假定每年有频率最高的前N个名字(N最小)
    * 的婴儿人数总和超过当年该性别总人数的50%，
    * N值随年份的变化趋势。（名字多样化分析）
    * */
  @Test
  def five()={
    val sc=briup.getSparkContext("local[*]","movie_spark");
    //RDD[(文件路径名,文件内容)]
    val files: RDD[(String, String)] =sc.wholeTextFiles("/Users/angelia/IdeaProjects/BD1803/spark/baby/yob*");
    //RDD[(文件名,文件内容)]
    val filesInfo=files.map(x=>(x._1.substring(x._1.lastIndexOf("/")+1,x._1.length),x._2));
    val yearAndGenderAndNameAndNum=filesInfo.flatMap(line=>{
      //line 为每年的出生信息
      val arr=line._2.split("\n");
      var maleTotal=0;
      var fmaleTotal=0;
      val info= {
        arr.map(x => {
          val a = x.split(",");
          val num=a(2).trim.toInt;
          a(1) match {
            case "M" =>
              maleTotal+=num;
            case _ =>
              fmaleTotal+=num;
          }
          //年份 性别 名字 人数
          ((line._1,a(1)),(a(0),num));
        })
      }.map(x=>{
        x._1._2 match {
          case "F" =>
            (x._1,(x._2,fmaleTotal))
          case _ =>
            (x._1,(x._2,maleTotal))
        }
      });
      info
    });
    yearAndGenderAndNameAndNum.groupByKey().mapValues(iter=>{
      val info=iter.toList.sortBy(_._2)(Ordering[Int].reverse);
      var num:Double=0;
      import  scala.util.control.Breaks._;
      var count=0;
      var name="";
      var f:Double=0;
      breakable{
        info.map(
          x=>{
            f=x._1._2.toDouble/x._2.toDouble;
            num+=f;
            count+=1;
              if(num>=0.5)
                break();
            name=x._1._1;
          }
        )
      }
      (num,count)
    })
//      .mapValues(list=>list.reduce((x,y)=>("",x._2+y._2)))
      .sortByKey().foreach(println)
  }

}
*/
