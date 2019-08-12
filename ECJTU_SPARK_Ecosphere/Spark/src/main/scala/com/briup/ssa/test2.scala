package com.briup.ssa

import org.apache.spark.SparkContext

object test2 extends App {
 //  分析任务：
 //  1、130年中每年出生婴儿的男女比例
 //   2、出生婴儿男女比例最失调的N个年份
 //  3、名字叫做John,Harry,Mary,Marilyn婴儿的出生趋势
 //  4、按性别计算每年最常用的1000个名字人数占当年总出生人数的比例（名字多样化分析）
 //  5、按性别假定每年有频率最高的前N个名字(N最小)的婴儿人数总和超过当年该性别总人数的50%，N值随年份的变化趋势。（名字多样化分析）
 //  6、各年出生的男孩名字以d/n/y结尾的人数占当年的比例
 //  7、130年中，变化趋势最明显的前n个名字(可以考虑使用标准差度量)
    val sc: SparkContext = getSCTest("test2_kd")
 //  (1880年,Map(M -> 110493, F -> 90993))
 //  (1881年,Map(M -> 100748, F -> 91955))
 //  (1882年,Map(M -> 113687, F -> 107851))
 //  (1883年,Map(M -> 104632, F -> 112322))
  //  男女出生人数相减，得到一年的差值，比较每年的差值大小，得到排序结果
     sc.longAccumulator("name")

}