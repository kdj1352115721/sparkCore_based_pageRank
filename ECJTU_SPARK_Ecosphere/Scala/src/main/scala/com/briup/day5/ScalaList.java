package com.briup.day5;

import java.util.Arrays;
import java.util.List;

public class ScalaList<Int>{
   private int head;
   private ScalaList<Int> tail;
   private StringBuffer sb;


    public ScalaList(int head, ScalaList<Int> tail) {
        this.head = head;
        this.tail =tail;
    }

    public ScalaList(){
        sb = new StringBuffer();
    }

    public void add(int i){
//        sb.append();
        //把之前的头元素加到后面的集合中，新添加的原始作为新的头
        this.head = i;
    }

    public int getHead(){
        return  this.head ;
    }
    public ScalaList<Int> getTail(){
        return  this.tail;
    }


//    private static List mkdirlist(List list){
//        list1 = Arrays.asList();
//        list.forEach(elem -> list1.add(elem));
//        return list1;
//    }


    //需要实现     拿到 tail.tail.head的值
}
