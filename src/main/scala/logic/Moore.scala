package logic

/* A Moore machine */

abstract class Moore[In,State,Out](val init : State, val in : Signal[In]) extends Wire[Out] {
  
  def next(s : State, inv : In) : State
  def output(s : State) : Out
  
  val state : Signal[State] = for (s <- (init :: state); inv <- in) yield next(s,inv)
  (for (s <- state) yield output(s)) |> this
}