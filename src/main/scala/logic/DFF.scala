package logic

class DFF[T](
  val init: T = new Default[T].get(),
  val ctl: Signal[Boolean] = new Wire[Boolean],
  val din: Signal[T] = new Wire[T]) extends Wire[T] {

  (init :: MUX(ctl, (true -> din), (false -> this))) |> this
}