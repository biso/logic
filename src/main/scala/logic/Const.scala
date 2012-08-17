package logic

class Const[+T](val v : T) extends Signal[T] {
  def apply(ts : Int) = v
}

object Const {
  def apply[T](v : T) = new Const(v)
}