import org.scalatest._
import org.scalatest.EitherValues._
import org.scalatest.concurrent.Timeouts

class GreeterSpec extends FunSpec with DiagrammedAssertions {
  val greeter = new Greeter

  describe("greet") {
    it("あいさつする") {
      assert(greeter.greet() == "おはようございます")
    }
  }
}
