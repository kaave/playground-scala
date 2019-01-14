import com.github.nscala_time.time.Imports._

trait TimeRange {
  val id: String
  val start: DateTime
  val end: DateTime
  def contains(dt: DateTime): Boolean
}
