package com.briup.test

import org.apache.spark.{Partition, SparkContext}
import org.apache.spark.rdd.RDD

object test1 extends App {
   // 基本RDD
   val sc: SparkContext =getSCTest("test1_kd")
   val data: Array[Int] = Array(1,2,3,4,5,6,7,8,9)
   val dataRDD: RDD[Int] = sc.parallelize(data)

   // 本地当前目录下文件
   val File1: RDD[String] = sc.textFile("files/info.txt")
//   // hdfs
////   val File2 = sc.textFile("hdfs://172.16.0.4:9000/kang/data.txt")
//   //读取目录
//    val File3: RDD[String] = sc.textFile("/files")
//   //读取含有通配符的路径：
//    val file4  = sc.textFile("/files/*.txt")
//    // 读取压缩文件
//    val file5 = sc.textFile("/files/*.gz")
//    1  map
   val rdd1: RDD[Int] = sc.parallelize(1 to 6)  //  第二个参数是它指定了将数据集切分为几份 也就是几个分区（分片）
   // 按照原序排序
   val rdd2: RDD[Int] = rdd1.map(x => x*2)
   // 乱序
   val rdd3: Array[Int] = rdd2.collect()
//   rdd3.foreach(println)
//    println("-----------------")
//   rdd2.foreach(println)
   // 按照函数作用于集合中每一个元素，

 // 2  filter
     val rdd4: RDD[Int] = rdd2.filter(x => x >10)
     val rdd5: Array[Int] = rdd4.collect()
//     rdd4.foreach(println)
//     println("-------------------")
//     rdd5.foreach(println)
   //  把符合条件的留下
    // 3 flatMap
   //
    val rdd6: RDD[Int] = rdd4.flatMap(x => x to 20)
    val rdd7: Array[Int] =rdd6.collect()
//      rdd6.foreach(println)
//      println("-------------------")
//      rdd7.foreach(println)
   // 结果输出为每一项 x -> 20 再铺平为一个RDD集合
    // mapPartitions,和map 作用一样，但是作用对象不同于map的作用于每一个元素，mapPartition作用于每一个分区的迭代器
   val maprdd1: RDD[Int] = sc.parallelize(1 to 10)
   def doubleMap(i:Int)={
      i*2
   }
   val doublerdd2: RDD[Int] = maprdd1.map(doubleMap)
//   doublerdd2.foreach(println)
   println("_-------------------------------")
   def doubleMapPar(iter:Iterator[Int])={
    import scala.collection.mutable
       var doubleList = mutable.ListBuffer[Int]()
       while(iter.hasNext){
         val next: Int = iter.next()
          doubleList+=(next*2)
       }
        doubleList.iterator
   }
   val doublerdd3: RDD[Int] = maprdd1.mapPartitions(doubleMapPar)
   val p: Array[Partition] = doublerdd3.partitions
//   println("分区数:"+doublerdd3.partitions.foreach(println))
//   doublerdd3.foreach(println)
   // mapPartion的操作时对一个分区的迭代器进行操作，再从迭代器中去对每个元素进行处理
    // mapPartironsWithIndex  会显示哪个分区来处理那些数据
    def doubleMapParWithIndex(i:Int =2,iter:Iterator[Int])={
     import scala.collection.mutable
     var doubleList = mutable.ListBuffer[String]()
     while(iter.hasNext){
      val next: Int = iter.next()
      doubleList+=("Partirion:"+i+"data:"+next*2)
     }
     doubleList.iterator
    }
   val Indexrdd2: RDD[String] = maprdd1.mapPartitionsWithIndex(doubleMapParWithIndex)
    Indexrdd2.partitions.foreach(println)
    println("--------------------------------")
//   Indexrdd2.foreach(println)
   // sample   随机抽样， （1,2,3）三个参数  1：是否放回，2：占总数的百分之几 ，3：根据给定的seed种子  不懂
   val sampleRdd1 = sc.parallelize( 1 to 100)
   val sRdd2: RDD[Int] = sampleRdd1.sample(false,0.1,0)
//    sRdd2.foreach(println)
   val sRdd3: Long = sRdd2.count()
//    println(sRdd3)

  // union  两个RDD的并集
   val unionRDD1 = sc.parallelize( 1 to 10)
   val unionRDD2 = sc.parallelize(5 to 15)
   val union: RDD[Int] = unionRDD1.union(unionRDD2)
//   union.foreach(println)

   // intersection  两个RDD的交集
    val inter: RDD[Int] = unionRDD1.intersection(unionRDD2)
//    inter.foreach(println)


   // distinct 去重  对一个RDD进行去重操作
   val disRDD1: RDD[String] = sc.parallelize(List("a","b","a","b"))
//    disRDD1.foreach(println)
    val disRDD2: RDD[String] = disRDD1.distinct()
 println("--------------------")
//    disRDD2.foreach(println)

    // groupByKey  对PairRDD使用   其中的key不太明白
     val groupRDD1: RDD[(Int, String)] = sc.parallelize(Array((1,"a"),(2,"b"),(3,"c"),(4,"a"),(5,"b")))
     //  由(k,v)  =====>  （k, seq[U]）
     val groupRDD2: RDD[(Int, Iterable[String])] =groupRDD1.groupByKey()
//     groupRDD2.foreach(println)
//     (2,CompactBuffer(a, a))
//     3,CompactBuffer(c))
//     (1,CompactBuffer(a, b))



    //reduceByKey  感觉是先被groupBYKey  再对value中元素进行Reduce函数操作 参数是value中的两个元素
     val reduceRDD1: RDD[(Int, String)] = groupRDD1.reduceByKey(_+"::"+_)
//     reduceRDD1.foreach(println)

      // 结果 ： (2,a::a)
      //         (1,a::b)
      //          (3,c)

    // aggregate
    val aggregateRDD1 = sc.parallelize(List(1,2,3,4,6))
    val aRDD2: Int = aggregateRDD1.aggregate(0)(SeqOP,CombOp)
    var flag = 0
    var flag2 = 0
    def SeqOP(i1: Int,i2:Int):Int={
       flag+= 1
//       println("flag:"+flag+" "+"max: "+math.max(i1,i2)+"    "+"i1:"+i1+"-----------------"+"i2:"+i2)
       math.max(i1,i2)
    }
    def  CombOp(i1:Int,i2:Int) ={
       flag2+=1
//       println("flag2: "+flag2+"  "+"i1:"+i1+"---------"+"i2:"+i2)
       i1+i2
    }
//    println("aRRD2:"+aRDD2)
    // seqOP 分区1中  0 ---4 ===>4 , 4----6====>6
   //   分区2中  0 ----1====>1
   // 分区3中   0----2====》2
    // 分区4中  0----3 ====> 3

   // CombOp   每个分区内出一个最大值相加，最初始值0      6+1+2+3
   //结果 12
  //  seqOp中每个分区内一个值先和初始值比较大小，较大者再和分区内其他元素比较大小，所以只有一个分区只有一个最大值，然后在combOp中，每个分区的最大值出来进行操作

   // aggregateByKey
     val aggregateRDD3 = sc.parallelize(List((1,1),(1,2),(1,3),(2,4),(2,5)))
     val aRDD3: RDD[(Int, Int)] = aggregateRDD3.aggregateByKey(100)(SeqOP3,CombOp3)
      var s3 = 0
      var c3 = 0
     def SeqOP3(i1: Int,i2:Int):Int={
      s3+= 1
//      println("flag:"+s3+" "+"i1+i2="+(i1+i2)+"    "+"i1:"+i1+"-----------"+"i2:"+i2)
      i1+i2
     }
     def  CombOp3(i1:Int,i2:Int) ={
      c3+=1
//      println("Comb:"+c3+" "+"i1+i2="+(i1+i2)+"    "+"i1:"+i1+"-----------"+"i2:"+i2)
      i1+i2
     }
//     aRDD3.foreach(println)
        // 第一步：
        // 分区1
        // flag:1 i1+i2=104    i1:100-----------i2:4
       //flag:2 i1+i2=109    i1:104-----------i2:5

       //  分区2 flag:3 i1+i2=102    i1:100-----------i2:2
        // 分区3 flag:4 i1+i2=103    i1:100-----------i2:3
        //  分区4  flag:5 i1+i2=101    i1:100-----------i2:1

      // 第二步：
     //Comb:1 i1+i2=203    i1:101-----------i2:102     k 为 1
     //Comb:2 i1+i2=306    i1:203-----------i2:103

     // 只有109    k 为2
    //(1,306)，(2,109)
    //   seqOp中，同一分区内，初始值和4做操作，得到104.104作为新的初始值再和分区内剩余的5做操作，得到109，每个分区都这样操作一番
    //    Comb中， 将k值相同的value（个数大于1）从所有的分区上拉取过来，做comb内的函数操作，如果个数等于1，就默认改值为最终k值对应的value值



   // aggregateByKey
   val aggreRDD1 = List((1,"a"),(1,"b"),(1,"c"),(2,"d"),(2,"e"))
   val aggreRDD2: RDD[(Int, String)] = sc.parallelize(aggreRDD1)
   var f1 = 0
   var f2 = 0
   val a3: RDD[(Int, String)] = aggreRDD2.aggregateByKey("100")(seqOP1,combOp1)
   def seqOP1(s1:String,s2:String):String={
        f1 +=1
//        println("f1: "+f1+" "+"s1:"+s1+" "+"s2:"+s2 +" "+"结果："+s1+s2)
        s1+s2
   }
   def combOp1(s1:String,s2:String):String={
        f2 += 1
//        println("f2:"+f2+"  "+"s1:"+s1+" "+"s2:"+s2+" "+"结果："+s1+"::"+s2)
        s1+"::"+s2
   }
  println("====================")
//  a3.foreach(println)
// List((1,"a"),(1,"b"),(1,"c"),(2,"d"),(2,"e"))
        // seqOp
      // 分区1 f1: 1 s1:100 s2:a 结果：100a
      //分区2  f1: 2 s1:100 s2:b 结果：100b

      //分区3  f1: 1 s1:100 s2:d 结果：100d
      //f1: 3 s1:100d s2:e 结果：100de  最终

      //分区4  f1: 1 s1:100 s2:c 结果：100c

        //combOp
      //f2:1  s1:100a s2:100b 结果：100a::100b         K 为1
      //f2:2  s1:100a::100b    s2:100c 结果：100a::100b::100c
      //  100de    K 为 2
      //(1,100a::100b::100c) ,    (2,100de)

      // seqOp       同一分区中， 一个value值d和初始值100进行操作得到结果100d，100d继续作为初始值，和该分区内的剩余value值e做操作 100de
    //  combOp         按照k值，将不同分区的最终value值，拉取过来，如果个数大于1个，就进行comB内函数的操作，一个就默认输出

   // combineByKey

   val combine: Array[(Int, Double)] = Array((1,1.0),(1,2.0),(1,3.0),(2,4.0),(2,5.0))
   val combineRDD1: RDD[(Int, Double)] = sc.parallelize(combine)

   val combine1: RDD[(Int, Double)] = combineRDD1.combineByKey(createCombiner,mergeValue,mergeCombiners)

   def createCombiner(a:Double)={
       a
   }
   var cb1 = 0 // 标志器
   var cb2 =0
  def mergeValue(a:Double,b:Double)={
      cb1+=1
//      println("cb1:"+cb1+" "+"a: "+a+"      "+"b: "+b+"结果a+b ："+ (a+b))
      a+b
  }
  def mergeCombiners(a:Double,b:Double)={
    cb2+=1
//   println("cb2:"+cb2+" "+"a: "+a+"     "+"b: "+b+"结果a+b ："+ (a+b))
      a+b
  }
//   println("combine============")
//   combine1.foreach(println)

   //   Array((1,1.0),(1,2.0),(1,3.0),(2,4.0),(2,5.0))
   //  第一步  createcombiner : 先对每个分区内的《k,v》中的v进行createCombiner中的函数操作，一般是转化，value值类型可转化为其他集合类型
   //  第二步   mergevalue  : 对value进行操作，在同一个分区内进行nergeValue中的函数操作，一个一个进行，最后得到一个值
   //  第三部   mergeCombiner : 把k值相同的  value值 从不同的分区内拉取过来进行mergeCombiner中的函数操作，如果只有一个值，那就默认输出这个值作为这个k的value值

        // cb1:1 a: 4.0      b: 5.0结果a+b ：9.0

      // cb2:1 a: 1.0     b: 2.0结果a+b ：3.0
      // cb2:2 a: 3.0     b: 3.0结果a+b ：6.0
      // (2,9.0),(1,6.0)
    // sortByKey
     val sortRDD = sc.parallelize(Array((1,1),(1,2),(1,3),(2,4),(2,5)))
     val s1: RDD[(Int, Int)] = sortRDD.sortByKey()
//     s1.foreach(println)
      // (2,4)
      // (2,5)
      //  (1,1)
      // (1,2)
      // (1,3)

    // join  （k,V） join （k,W） ===> (k,(V,W))
     val joinRDD1: RDD[(Int, (Int, Int))] = sortRDD.join(sortRDD)
//     joinRDD1.foreach(println)
    // k 值相同的情况下，  一个RDD每个value值都和对方的一个RDD的value值进行整合成元组形式
// Array((1,1),(1,2),(1,3),(2,4),(2,5)) join  Array((1,1),(1,2),(1,3),(2,4),(2,5))
          // (2,(4,4))
          // (2,(4,5))
          // (2,(5,4))
          // (2,(5,5))
          // (1,(1,1))
          // (1,(1,2))
          // (1,(1,3))
          // (1,(2,1))
          // (1,(2,2))
          // (1,(2,3))
          // (1,(3,1))
          // (1,(3,2))
          // (1,(3,3))

   // cogroup   (k,v) cogroup (k,W)  ====> (k, Seq(V),Seq(W))
      val cogRDD1: RDD[(Int, (Iterable[Int], Iterable[Int]))] =  sortRDD.cogroup(sortRDD)
//      cogRDD1.foreach(println)
//   Array((1,1),(1,2),(1,3),(2,4),(2,5))
      // (1,(CompactBuffer(1, 2, 3),CompactBuffer(1, 2, 3)))
      // (2,(CompactBuffer(4, 5),CompactBuffer(4, 5)))


  // 对于《k,v》的pairRDD 将 相同k值 的 value值 聚合起来 包装成Seq形式的



   // cartesian 笛卡尔积   单值数据集T cartesian  U   ====》 (（t1,u1）,(t1,u2),(t2,u1),(t2,u2))
       val c1 = sc.parallelize(Array(1,2,3))
       val c2 = sc.parallelize(Array(4,5,6))
      val carRDD: RDD[(Int, Int)] = c1.cartesian(c2)
//       carRDD.foreach(println)
     // 结果：
         // (1,4),(1,6)(1,5)(2,4)
         // (2,6)(2,5)(3,4)(3,5)(3,6)

   // mapvalues
   val a: RDD[String] = sc.parallelize(List("dog", "tiger", "lion", "cat", "panther", " eagle"))
   val b: RDD[(Int, String)] = a.map(x => (x.length, x))
   val r: RDD[(Int, String)] = b.mapValues(x => x)
    r.foreach(println)

// (3,xdogx)
// (5,xtigerx)
// (4,xlionx)
}
