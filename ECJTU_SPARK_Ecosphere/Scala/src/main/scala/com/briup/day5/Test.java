package com.briup.day5;

import scala.Int;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {


        ScalaList scalaList = new ScalaList(1,new ScalaList());
        int head = scalaList.getHead();
        System.out.println(head);

        ScalaList tail = scalaList.getTail();
        System.out.println(tail);

        scalaList.add(8);




    }
}

