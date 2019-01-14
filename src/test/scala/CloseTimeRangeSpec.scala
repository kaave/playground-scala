import org.scalatest._
import com.github.nscala_time.time.Imports._

class CloseTimeRangeSpec extends FunSpec with DiagrammedAssertions {
  describe("contains") {
    it("時間帯に含むか") {
      val range = new CloseTimeRange("",
                                     DateTime.parse("2018-01-01T05:00:00"),
                                     DateTime.parse("2018-01-01T12:00:00"))
      assert(!range.contains(DateTime.parse("2018-01-01T04:00:00")))
      assert(range.contains(DateTime.parse("2018-01-01T05:00:00")))
      assert(range.contains(DateTime.parse("2018-01-01T10:00:00")))
      assert(!range.contains(DateTime.parse("2018-01-01T12:00:00")))
      assert(!range.contains(DateTime.parse("2018-01-01T20:00:00")))
    }
  }
}
