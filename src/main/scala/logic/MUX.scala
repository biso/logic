package logic

case class MUX[Ctl,Val] (
	val ctl : Signal[Ctl],
	val pairs : (Ctl, Signal[Val])*) extends Signal[Val] {

	def apply(ts : Int) : Val = {
		val c = ctl(ts)
		pairs.find { p => p._1 == c } match {
			case None => throw new Exception("invalid ctl %d".format(c))
			case Some(x) => x._2(ts)
		}
	}
}