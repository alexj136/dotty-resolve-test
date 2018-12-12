import org.scalacheck.Properties
import org.scalacheck.Prop.forAll

object Tests extends Properties("HelloWorldTest") {
  property("helloWorldProp") = forAll { l: List[String] =>
    l.reverse.reverse == l
  }
}
