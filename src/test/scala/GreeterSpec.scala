import org.scalatest._
import org.scalatest.mockito.MockitoSugar
import org.mockito.Mockito._
import com.github.nscala_time.time.Imports._

class GreeterSpec extends FunSpec with DiagrammedAssertions with MockitoSugar {
  describe("greet") {
    it("朝のあいさつは「おはようございます」") {
      val mockClock: Clock = mock[Clock]
      when(mockClock.getCurrentTime)
        .thenReturn(DateTime.parse("2019-01-12T08:00:00"))
      val greeter = new Greeter(dt = mockClock.getCurrentTime)

      assert(greeter.greet() == "おはようございます")
    }

    it("朝でなければスルー") {
      val mockClock: Clock = mock[Clock]
      when(mockClock.getCurrentTime)
        .thenReturn(DateTime.parse("2019-01-12T15:00:00"))
      val greeter = new Greeter(dt = mockClock.getCurrentTime)

      assert(greeter.greet() == "")
    }
  }
}
