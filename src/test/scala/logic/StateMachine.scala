package logic

import org.scalatest._

class StateMachine extends FunSuite {
  
  test("s1") {
    val time = new Counter()
    
    object Status extends Moore[Int,Int,Int](0,time) {
      def next(s : Int, inv : Int) = s + 1
      def output(s : Int) = s
    }
    
  }
  

}