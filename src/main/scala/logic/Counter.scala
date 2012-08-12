package logic

class Counter(
    val load: Signal[Boolean] = Const(false),
    val value: Signal[Int] = Const(0),
    val init: Int = 0,
    val step: Int = 1) extends Wire[Int] {

  input = init :: MUX(load,
    (true -> Const(init)),
    (false -> (this + Const(step))))

}

object Counter {
  def apply(load: Signal[Boolean] = Const(false),
    value: Signal[Int] = Const(0),
    init: Int = 0,
    step: Int = 1) = new Counter(load, value, init, step)
}