import time_range.TimeRange
import com.github.nscala_time.time.Imports._

class Greeter(val datetime: DateTime, val timeRange: TimeRange) {
  def greet(): String = {
    if (timeRange.contains(datetime)) {
      "おはようございます"
    } else {
      ""
    }
  }
}
