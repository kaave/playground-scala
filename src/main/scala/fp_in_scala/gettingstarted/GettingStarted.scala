//package fp_in_scala.gettingstarted

object MyModule {
  def abs(n: Int): Int = if (n < 0) -n else n

  def factorial(n: Int): Int = {
    @annotation.tailrec
    def go(n: Int, acc: Int): Int = if (n <= 0) acc else go(n - 1, n * acc)

    go(n, 1)
  }

  private def formatAbs(x: Int): String = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  private def formatFactorial(x: Int): String = {
    val msg = "The factorial value of %d is %d"
    msg.format(x, factorial(x))
  }

  def formatResult(name: String, x: Int, f: Int => Int): String = {
    "The %s of %d is %d".format(name, x, f(x))
  }

  /*
   * practice
   */
  def fib(count: Int): Int = {
    def go(ary: Array[Int], currentCount: Int): Int = {
      val sum = ary(0) + ary(1)

      if (currentCount >= count)
        sum
      else
        go(sum +: ary, currentCount + 1)
    }

    go(Array(1, 0), 2)
  }

//  def main(args: Array[String]): Unit = println(factorial(2))
//  def main(args: Array[String]): Unit = println(fib(10))
  def main(args: Array[String]): Unit = {
    println(formatResult("absolute value", -42, abs))
    println(formatResult("factorial value", 7, factorial))
  }
}
