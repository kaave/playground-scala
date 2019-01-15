package time_range

import com.github.nscala_time.time.Imports._

object TimeRangeFactory {
  def create(id: String, start: DateTime, end: DateTime): TimeRange = {
    if (start.getHourOfDay < end.getHourOfDay ||
        (start.getHourOfDay == end.getHourOfDay && start.getMinuteOfHour < end.getMinuteOfHour) ||
        (start.getHourOfDay == end.getHourOfDay && start.getMinuteOfHour == end.getMinuteOfHour && start.getSecondOfMinute < end.getSecondOfMinute)) {
      new CloseTimeRange(id, start, end)
    } else {
      new OpenTimeRange(id, start, end)
    }
  }
}
