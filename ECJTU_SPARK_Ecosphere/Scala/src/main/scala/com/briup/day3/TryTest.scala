package com.briup.day3

object TryTest  {
 def main(args: Array[String]): Unit = {
//  log("aa")
  val p: Person = new Person("jack",20)


/*
  val s:String = null
  try {
   show(s)
  }catch {
   case e:NullPointerException=>{e.printStackTrace()}
   case e:Exception =>{e.printStackTrace()}
   case _=>{}
  }finally {
   println("=============")
  }
  //异常只是代码在运行过程中的一种通知系统
  println("---------------------")

*/

 }

  def show(msg:String):Unit={
    if(msg == null ){
     throw new NullPointerException("msg == null")
    }else{
     println("msg"+msg)
    }



  }

}
