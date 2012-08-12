package logic

trait Signal[T] extends (Int => T) { parent =>

	def map[U](f : T => U) = new Signal[U] {
		def apply(t : Int) = f(parent(t))
	}

	def flatMap[U](f : T => Signal[U]) = new Signal[U] {
		def apply(ts : Int) = f(parent(ts))(ts)
	}

	def buffer = Wire[T](this)
	
	def latch(init : T) = new Latch(init, this)

	def zip[U](other : Signal[U]) = Pair(this,other)

	def ::(x : T) = latch(x)
}