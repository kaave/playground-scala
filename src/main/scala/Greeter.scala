import time_range.TimeRange
import com.github.nscala_time.time.Imports._

class Greeter(val datetime: DateTime) {
  var timeRangeAndGreeting: List[(TimeRange, String)] = List()
  def addTimeRangeAndGreeting(timeRange: TimeRange, greeting: String) =
    timeRangeAndGreeting :+ (timeRange, greeting)
  def greet(): String = {
    if (timeRange.contains(datetime)) {
      "おはようございます"
    } else {
      ""
    }
  }
}
