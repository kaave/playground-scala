import com.github.nscala_time.time.Imports._

class Greeter(dt: DateTime) {
  private val datetime = dt

  def greet(): String = {
    if (MorningTimeRange.contains(datetime)) {
      "おはようございます"
    } else {
      ""
    }
  }
}
