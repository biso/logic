package object logic {

  implicit def boolSignalToIntSignal(x: Signal[Boolean]) = new IntSignal {
    def apply(ts: Int) = if (x(ts)) -1 else 0
  }

  implicit def intToIntSignal(x: Int) = new IntSignal {
    def apply(ts: Int) = x
  }
  implicit def intSignalToIntSignal(x: Signal[Int]) = new IntSignal {
    def apply(ts: Int) = x(ts)
  }

  implicit def boolToBoolSignal(x: Boolean) = new BoolSignal {
    def apply(ts: Int) = x
  }

  implicit def boolSignalToBoolSignal(x: Signal[Boolean]) = new BoolSignal {
    def apply(ts: Int) = x(ts)
  }

}