import com.github.nscala_time.time.Imports._

trait TimeRange {
  def contains(dt: DateTime): Boolean
}

object MorningTimeRange extends TimeRange {
  def contains(dt: DateTime): Boolean =
    dt.getHourOfDay >= 5 && dt.getHourOfDay < 12
}
