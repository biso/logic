package logic

trait Logic[In,+Out] { parent =>
  val in = new Wire[In]
  val out : Signal[Out]
  
  def |>[In2 >: Out, Out2](other : Logic[In2,Out2]) = new Logic[In,Out2] {
    parent.out |> other.in
    val out = other.out
  }

}