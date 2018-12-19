object A {
  def main(args: Array[String]): Unit = println(f())
  def f(): Int = {
    implicit val one: Int = 1
    val a: Int = {
      implicit val two: Int = 2
      implicitly[Int]
    }
    a
  }
}
