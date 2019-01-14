package time_range
import com.github.nscala_time.time.Imports.DateTime

trait TimeRange {
  val id: String
  val start: DateTime
  val end: DateTime
  def contains(dt: DateTime): Boolean
}
