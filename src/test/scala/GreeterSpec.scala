import org.scalatest._
import org.scalatest.mockito.MockitoSugar
import org.mockito.Mockito._
import org.mockito.ArgumentMatchers.any
import com.github.nscala_time.time.Imports._

class GreeterSpec extends FunSpec with DiagrammedAssertions with MockitoSugar {
  describe("greet") {
    it("朝のあいさつは「おはようございます」") {
      val mockTimeRange = mock[TimeRange]
      when(mockTimeRange.contains(any[DateTime])).thenReturn(true)
      val greeter =
        new Greeter(datetime = DateTime.now(), timeRange = mockTimeRange)

      assert(greeter.greet() == "おはようございます")
    }

    it("朝でなければスルー") {
      val mockTimeRange = mock[TimeRange]
      when(mockTimeRange.contains(any[DateTime])).thenReturn(false)
      val greeter =
        new Greeter(datetime = DateTime.now(), timeRange = mockTimeRange)

      assert(greeter.greet() == "")
    }
  }
}
