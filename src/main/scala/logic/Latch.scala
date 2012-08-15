package logic

class Latch[+T](val init : T = new Default[T].it, val din : Signal[T]) extends Signal[T] {
  
  private[this] var lastTs : Int = -1
  private[this] var lastVal : T = _
  
  def apply(ts : Int) = {
    if (ts != lastTs) {
      lastTs = ts
      if (ts == 0) lastVal = init else lastVal = din(ts-1)
    }
    lastVal
  }
}