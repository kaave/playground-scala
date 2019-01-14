import org.scalatest._
import com.github.nscala_time.time.Imports._

class MorningTimeRangeSpec extends FunSpec with DiagrammedAssertions {
  describe("contains") {
    it("朝の時間帯かどーか") {
      assert(!MorningTimeRange.contains(DateTime.parse("2018-01-01T04:00:00")))
      assert(MorningTimeRange.contains(DateTime.parse("2018-01-01T05:00:00")))
      assert(MorningTimeRange.contains(DateTime.parse("2018-01-01T10:00:00")))
      assert(!MorningTimeRange.contains(DateTime.parse("2018-01-01T12:00:00")))
      assert(!MorningTimeRange.contains(DateTime.parse("2018-01-01T20:00:00")))
    }
  }
}
