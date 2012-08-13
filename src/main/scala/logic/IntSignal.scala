package logic;

trait IntSignal extends Signal[Int] {
  def +(other: Signal[Int]) = for (x <- this; y <- other) yield x + y
  def -(other: Signal[Int]) = for (x <- this; y <- other) yield x - y
  def *(other: Signal[Int]) = for (x <- this; y <- other) yield x * y
  def /(other: Signal[Int]) = for (x <- this; y <- other) yield x / y
  def %(other: Signal[Int]) = for (x <- this; y <- other) yield x % y
  def |(other: Signal[Int]) = for (x <- this; y <- other) yield x | y
  def &(other: Signal[Int]) = for (x <- this; y <- other) yield x & y

  def <(other: Signal[Int]) = for (x <- this; y <- other) yield x < y
  def >(other: Signal[Int]) = for (x <- this; y <- other) yield x > y
  def !=(other: Signal[Int]) = for (x <- this; y <- other) yield x != y
  def <=(other: Signal[Int]) = for (x <- this; y <- other) yield x <= y
  def >=(other: Signal[Int]) = for (x <- this; y <- other) yield x >= y
  def ===(other: Signal[Int]) = for (x <- this; y <- other) yield x == y

  def >>(other: Signal[Int]) = for (x <- this; y <- other) yield x >> y
  def >>(other : Int) = for (x <- this) yield x >> other
      
  def >>>(other: Signal[Int]) = for (x <- this; y <- other) yield x >>> y
  def <<(other: Signal[Int]) = for (x <- this; y <- other) yield x << y

  def mask = (Const(1) << this) - Const(1)

  def pick(from: Int, to: Int) = this >> (31 - to)
}

object IntSignal {
  def apply(s: Signal[Int]) = new IntSignal {
    def apply(ts: Int) = s(ts)
  }
}