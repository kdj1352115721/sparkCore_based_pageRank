package com.briup.day8

trait T1 {
   def log(file:String)
}
trait T2 {
   def log(file:String)
}

trait T3 {

}

trait T4 extends T2 with T1 {
    def log(file:String): Unit ={
       println("t4")
    }
}