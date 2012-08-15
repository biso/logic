package logic

class Wire[T] extends Signal[T] {
  
  private[this] var input : Signal[T] = null

  private[this] var lastTs: Int = -1
  private[this] var lastVal: T = _

  def apply(ts: Int) : T = {
    if (ts != lastTs) {
      lastTs = ts
      lastVal = input(ts)
    }
    lastVal
  }
  
  def :=(src : Signal[T]) {
    if (input != null) throw new Exception("already connected")
    input = src
  }
}

object Wire {
  def apply[T] = new Wire[T]
  def apply[T](x : Signal[T]) = {
    val w = new Wire[T]
    w := x
    w
  }
}