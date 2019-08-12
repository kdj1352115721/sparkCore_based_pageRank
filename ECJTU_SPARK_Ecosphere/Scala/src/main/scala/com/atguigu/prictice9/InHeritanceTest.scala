package com.atguigu.prictice9

object InHeritanceTest {
 def main(args: Array[String]): Unit = {
  val acoount: CheckingAccount = new CheckingAccount(185800.00)
  acoount.deposit(20)
  println(acoount.check())
  println("=========================")
  //2
  val account1: SavingsAccount = new SavingsAccount(20000)
  account1.deposit(20)
  account1.deposit(30)
  account1.deposit(40)
  println(account1.check())
  account1.deposit(10)
  println(account1.check())
 }
}
class BankAccount(initailBalance:Double) {
 private var balance = initailBalance
//  存款
 def deposit(amount:Double) = {
   balance += amount
   balance
 }
 def withdraw(amount:Double) ={
   balance -= amount
   balance
 }
}
// 1
class CheckingAccount(initailBalance:Double){

 // 每次存取款都需收取1 $ 的书续费
 private var balance: Double = initailBalance

 // 存款
  def deposit(amount:Double)={
      balance -= 1
      balance += amount
      balance
  }
// 取款
  def withdraw(amount:Double)={
     balance -= 1
     balance -= amount
     balance
  }
  def check(): Double ={
     balance
  }

}

// 2
class SavingsAccount(initailBalance:Double){
  private var point = 3

 // 每次存取款都需收取1 $ 的书续费
 private var balance: Double = initailBalance
 // 存款
 def deposit(amount:Double)={
  if(point >0){
   balance += amount
   balance
   point -= 1
  }else{
   balance -= 1
   balance += amount
   balance
  }

 }
 // 取款
 def withdraw(amount:Double)={
  if(point>0){
   balance -= amount
   balance
   point -= 1
  }else{
   balance -= 1
   balance -= amount
   balance
  }
 }
 def check(): Double ={
  balance
 }
 // 利息
 def earnMonthlyInterest() ={
   val earnMonth: Double = balance.*(0.01).*(30)
   // 一次性产生30天的利息
   earnMonth
   point == 0
 }





}

