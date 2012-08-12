package logic

class DFF[T](
    val init : T,
	val ctl : Signal[Boolean],
	val din : Signal[T]) extends Wire[T] {
  
  this.input = init :: MUX(ctl, (true -> din), (false -> this))
}