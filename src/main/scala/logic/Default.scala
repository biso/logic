package logic

class Default[+T] {
  
  private[this] var it : T = _
  
  def get() = it

}