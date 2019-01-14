import com.github.nscala_time.time.Imports._

object MorningTimeRange {
  def contains(dt: DateTime): Boolean =
    dt.getHourOfDay >= 5 && dt.getHourOfDay < 12
}
