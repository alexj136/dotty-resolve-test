import scala.collection.Set
import scala.collection.SortedSet
object Sample2 {
  def main(args: Array[String]): Unit = println(f())
  def f(): Set[Int] = {
    implicit val one: Set[Int] = SortedSet(1)
    implicit val two: SortedSet[Int] = SortedSet(2)
    implicitly[Set[Int]]
  }
}
