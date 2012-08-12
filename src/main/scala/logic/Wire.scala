package logic

class Wire[T] extends Signal[T] {
  
  var input : Signal[T] = null

  var lastTs: Int = -1
  var lastVal: T = _

  def apply(ts: Int) = {
    if (ts != lastTs) {
      lastTs = ts
      lastVal = input(ts)
    }
    lastVal
  }
}

object Wire {
  def apply[T] = new Wire[T]
  def apply[T](x : Signal[T]) = {
    val w = new Wire[T]
    w.input = x
    w
  }
}