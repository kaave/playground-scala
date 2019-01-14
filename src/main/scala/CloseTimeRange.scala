import com.github.nscala_time.time.Imports._

class CloseTimeRange(val id: String, val start: DateTime, val end: DateTime)
    extends TimeRange {
  def contains(dt: DateTime): Boolean =
    start.getHourOfDay <= dt.getHourOfDay && dt.getHourOfDay < end.getHourOfDay
}
