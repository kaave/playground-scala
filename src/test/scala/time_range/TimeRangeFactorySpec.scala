package time_range

import com.github.nscala_time.time.Imports._
import org.scalatest._

class TimeRangeFactorySpec extends FunSpec with DiagrammedAssertions {
  describe("create") {
    it("狙ったのが取れるか") {
      assert(
        TimeRangeFactory
          .create("Close",
                  DateTime.parse("2018-01-01T05:00:00"),
                  DateTime.parse("2018-01-01T12:00:00"))
          .getClass == classOf[CloseTimeRange])

      assert(
        TimeRangeFactory
          .create("Open",
                  DateTime.parse("2018-01-01T05:00:00"),
                  DateTime.parse("2018-01-01T02:00:00"))
          .getClass == classOf[OpenTimeRange])

      assert(
        TimeRangeFactory
          .create("分 Close",
                  DateTime.parse("2018-01-01T05:00:00"),
                  DateTime.parse("2018-01-01T05:01:00"))
          .getClass == classOf[CloseTimeRange])

      assert(
        TimeRangeFactory
          .create("分 Open",
                  DateTime.parse("2018-01-01T05:30:00"),
                  DateTime.parse("2018-01-01T05:00:00"))
          .getClass == classOf[OpenTimeRange])

      assert(
        TimeRangeFactory
          .create("秒 Close",
                  DateTime.parse("2018-01-01T05:00:00"),
                  DateTime.parse("2018-01-01T05:00:10"))
          .getClass == classOf[CloseTimeRange])

      assert(
        TimeRangeFactory
          .create("秒 Open",
                  DateTime.parse("2018-01-01T05:00:10"),
                  DateTime.parse("2018-01-01T05:00:00"))
          .getClass == classOf[OpenTimeRange])

      assert(
        TimeRangeFactory
          .create("年月日を無視するか",
                  DateTime.parse("2018-01-01T05:00:00"),
                  DateTime.parse("2017-12-31T12:00:00"))
          .getClass == classOf[CloseTimeRange])
    }
  }
}
