package logic

class Mem[T : Manifest] (val size : Int,
    val wctl : Signal[Boolean],
    val waddr : Signal[Int],
    val wdata : Signal[T],
    val raddr : Signal[Int]) {
  
  val data = Array.fill[T](size) { new Default[T].it }
  
  val rd = new Signal[T] {
    def apply(ts : Int) : T = {
      val d = wdata(ts)
      val a = waddr(ts)
      val c = wctl(ts)
      if (c) {
        data(a) = d
      }
      data(raddr(ts))
    }
  }
  
  

}