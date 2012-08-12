package logic;

trait BoolSignal extends Signal[Boolean] {
	def & (other : Signal[Boolean]) = for (x <- this; y <- other) yield x & y
	def | (other : Signal[Boolean]) = for (x <- this; y <- other) yield x | y
	def ^ (other : Signal[Boolean]) = for (x <- this; y <- other) yield x ^ y
	def unary_!(other : Signal[Boolean]) = for (x <- this) yield !x
}