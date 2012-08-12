package logic

class Latch[T](val init : T, val in : Signal[T]) extends Signal[T] {
  
  private var lastTs : Int = -1
  private var lastVal : T = _
  
  def apply(ts : Int) = {
    if (ts != lastTs) {
      lastTs = ts
      if (ts == 0) lastVal = init else lastVal = in(ts-1)
    }
    lastVal
  }
}