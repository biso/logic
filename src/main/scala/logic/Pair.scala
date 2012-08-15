package logic

case class Pair[+T,+U](val _1 : Signal[T], val _2 : Signal[U]) extends Signal[(T,U)] {
	def apply(ts : Int) = (_1(ts),_2(ts))
}