import scala.collection.Set
import scala.collection.SortedSet
// Should not compile - the 'game of two rounds' should be a draw.
object Sample3 {
  def main(args: Array[String]): Unit = println(f())
  def f(): Set[Int] = {
    implicit val one: SortedSet[Int] = SortedSet(2)
    val a: Set[Int] = {
      implicit val two: Set[Int] = SortedSet(1)
      implicitly[Set[Int]]
    }
    a
  }
}
