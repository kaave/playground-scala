package datastructures

/*
 * sealedがつくとこのファイルの中からのみ継承可能に
 * +Aは変位を表す
 *   class Dog extends Animal
 *   の場合、 List[Dog] extends List[Animal]
 *   のようなものらしい
 */
sealed trait List[+A]

case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  /*
   * 3.1
   */
  val ex1: List[Double] = Nil
  val ex2: List[Int] = Cons(1, Nil)
  val ex3: List[String] = Cons("a", Cons("b", Nil))

  def sum(ints: List[Int]): Int = ints match {
    case Nil         => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil          => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs)  => x + product(xs)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty)
      Nil
    else
      Cons(as.head, apply(as.tail: _*))

  /*
   * 3.2
   */
  // exercise 3.1
  def exercise3dot1(): Int = {
    List(1, 2, 3, 4, 5) match {
      case Cons(x, Cons(2, Cons(4, _)))          => x
      case Nil                                   => 42
      case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y // match here
      case Cons(h, t)                            => h + sum(t)
      case _                                     => 101
    }
  }

  /*
   * 3.3
   */
  // exercise 3.2
  def tail[A](l: List[A]): List[A] = l match {
//    case Nil        => List()
    case Nil        => sys.error("tail of empty list")
    case Cons(_, t) => t
  }

  // exercise 3.3
  def setHead[A](l: List[A], value: A): List[A] = l match {
//    case Nil        => List()
    case Nil        => sys.error("setHead of empty list")
    case Cons(_, t) => Cons(value, l)
  }

  // exercise 3.4
  def drop[A](l: List[A], n: Int): List[A] =
    if (n <= 0)
      l
    else
      l match {
        case Nil        => Nil
        case Cons(_, t) => drop(t, n - 1)
      }

  // exercise 3.5
  // カリー化させて第2引数の関数のAが推測されるようにする
//  def dropWhile[A](l: List[A], f: A => Boolean): List[A] =
  def dropWhile[A](l: List[A])(f: A => Boolean): List[A] =
    l match {
//      case Cons(h, t) if f(h) => dropWhile(t, f)
      case Cons(h, t) if f(h) => dropWhile(t)(f)
      case _                  => l
    }

  def append[A](a1: List[A], a2: List[A]): List[A] =
    a1 match {
      case Nil        => a2
      case Cons(h, t) => Cons(h, append(t, a2))
    }

  // exercise 3.6
  def init[A](l: List[A]): List[A] =
    l match {
      case Nil          => sys.error("init of empty list")
      case Cons(_, Nil) => Nil
      case Cons(h, t)   => Cons(h, init(t))
    }

  /*
   * 3.4
   */
  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B =
    as match {
      case Nil         => z
      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }

  def sum2(ns: List[Int]): Int =
    foldRight(ns, 0)(_ + _) // _ + _ == (x, y) => x + y

  def product2(ns: List[Double]): Double =
    foldRight(ns, 1.0)(_ * _) // _ * _ == (x, y) => x * y

  // exercise 3.7
  // product2が0.0を検出した場合に直ちに再帰を中止して0.0を返せるか？
  // -> できないようにみえるが…Double.*になんか凝った実装があるなら知らない

  // exercise 3.8
  // foldRight(List(1, 2, 3), Nil: List[Int])(Cons(_, _))のように
  // NilおよびCons自体をfoldRightにわたすとどうなるか
  // -> List(1, 2, 3)が返ってきた なんだろ

  // exercise 3.9
  def length[A](as: List[A]): Int = foldRight(as, 0)((_, i) => i + 1)

  // exercise 3.10
  // foldRightは末尾再帰してないのでする
  @annotation.tailrec
  def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = as match {
    case Nil        => z
    case Cons(h, t) => foldLeft(t, f(z, h))(f)
  }
}
