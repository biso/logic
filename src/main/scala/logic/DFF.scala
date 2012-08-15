package logic

class DFF[T](
  val init: T = new Default[T].it,
  val ctl: Signal[Boolean] = new Wire[Boolean],
  val din: Signal[T] = new Wire[T]) extends Wire[T] {

  this := init :: MUX(ctl, (true -> din), (false -> this))
}