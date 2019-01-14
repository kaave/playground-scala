import com.github.nscala_time.time.Imports._

class Greeter(dt: DateTime) {
  private val datetime = dt

  private def isMorning(): Boolean = {
    datetime.getHourOfDay >= 5 && datetime.getHourOfDay <= 12
  }

  def greet(): String = {
    if (isMorning) {
      "おはようございます"
    } else {
      ""
    }
  }
}
