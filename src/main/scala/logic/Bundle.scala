package logic

class Bundle[+T](val parts : Signal[T]*) extends Signal[Traversable[T]] {
	def apply(ts : Int) = for (v <- parts) yield v(ts)
}