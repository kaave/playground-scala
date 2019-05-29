//package fp_in_scala.gettingstarted

object MyModule {
  def abs(n: Int): Int = if (n < 0) -n else n

  def factorial(n: Int): Int = {
    @annotation.tailrec
    def go(n: Int, acc: Int): Int = if (n <= 0) acc else go(n - 1, n * acc)

    go(n, 1)
  }

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
   * 2.5
   */
  def findFirst[A](as: Array[A], p: A => Boolean): Int = {
    @annotation.tailrec
    def loop(n: Int): Int =
      if (n >= as.length)
        -1
      else if (p(as(n)))
        n
      else
        loop(n + 1)

    loop(0)
  }

  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    def loop(i: Int): Boolean =
      if (i >= as.length)
        true
      else if (!ordered(as(i), as(i - 1)))
        false
      else
        loop(i + 1)

    loop(1)
  }

  /*
   * 2.6
   */
  def partial1[A, B, C](a: A, f: (A, B) => C): B => C = (b: B) => f(a, b)

  /*
   * practice
   */
  def curry[A, B, C](f: (A, B) => C): A => B => C =
    (a: A) => (b: B) => f(a, b)
  def uncurry[A, B, C](f: A => B => C): (A, B) => C =
    (a: A, b: B) => f(a)(b)
  def compose[A, B, C](f: B => C, g: A => B): A => C = (a: A) => f(g(a))
  // same
//  def compose[A, B, C](f: B => C, g: A => B): A => C = f compose g
//  def compose[A, B, C](f: B => C, g: A => B): A => C = f andThen g

//  def main(args: Array[String]): Unit = println(factorial(2))
//  def main(args: Array[String]): Unit = println(fib(10))
  def main(args: Array[String]): Unit = {
//    println(formatResult("absolute value", -42, abs))
//    println(formatResult("factorial value", 7, factorial))
    println(isSorted(Array(1, 3, 7, 5, 9), (i: Int, j: Int) => i > j))
  }
}
