package logic

trait Signal[+T] extends (Int => T) { parent =>

	def map[U](f : T => U) = new Signal[U] {
		def apply(t : Int) = f(parent(t))
	}

	def flatMap[U](f : T => Signal[U]) = new Signal[U] {
		def apply(ts : Int) = f(parent(ts))(ts)
	}
	
	def latch[U >: T](init : U) = new Latch(init, this)

	def zip[U](other : Signal[U]) = Pair(this,other)

	def ::[U >: T](x : U) = latch(x)
	
	def <|[U >: T](other : Signal[U]) {
	  throw new Exception("can't be driven")
	}
	
	def |>[U >: T](other : Signal[U]) {
	  other <| this
	}
}