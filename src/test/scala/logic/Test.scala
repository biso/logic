package logic

import org.scalatest._

class LogicTest extends FunSuite {

  test("constant signal") {
    val s = Const[Int](10)
    assert(s(100) === 10)
  }

  test("add") {
    val s1 = Const[Int](10)
    val s2 = Const[Int](20)
    val s3 = s1 + s2
    assert(s3(666) === 30)
  }

  test("counter") {
    val c1 = new Counter()
    assert(c1(0) === 0)
    assert(c1(20) === 20)
  }

}
