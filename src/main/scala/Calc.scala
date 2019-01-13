class Calc {
  def sum(seq: Seq[Int]): Int = seq.foldLeft(0)(_ + _)

  def div(numerator: Int, denominator: Int): Either[String, Double] = {
    if (denominator == 0)
      Left("/ by zero")
    else
      Right(numerator.toDouble / denominator.toDouble)
  }

  def isPrime(n: Int): Boolean = {
    if (n < 2)
      false
    else
      !((2 to Math.sqrt(n).toInt) exists (n % _ == 0))
  }
}
