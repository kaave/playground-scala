package time_range

import com.github.nscala_time.time.Imports._

class OpenTimeRange(val id: String, val start: DateTime, val end: DateTime)
    extends TimeRange {
  def contains(dt: DateTime): Boolean =
    dt.getHourOfDay < start.getHourOfDay || end.getHourOfDay <= dt.getHourOfDay
}
