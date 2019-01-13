// https://dwango.github.io/scala_text/test.html

import org.scalatest._
import org.scalatest.EitherValues._
import org.scalatest.concurrent.Timeouts
import org.scalatest.time.SpanSugar._
import org.scalatest.mockito.MockitoSugar
import org.mockito.Mockito._

class CalcSpec
    extends FunSpec
    with DiagrammedAssertions
    with Timeouts
    with MockitoSugar {
  val calc = new Calc

  describe("sum") {
    it("整数の配列を取得し、それらを足し合わせた整数を返すことができる") {
      assert(calc.sum(Seq(1, 2, 3)) === 6)
      assert(calc.sum(Seq(0)) === 0)
      assert(calc.sum(Seq(-1, 1)) === 0)
      assert(calc.sum(Seq()) === 0)
    }

    it("Intの最大を上回った際にはオーバーフローする") {
      assert(calc.sum(Seq(Integer.MAX_VALUE, 1)) === Integer.MIN_VALUE)
    }
  }

  describe("div") {
    it("0で割るとLeft") {
      assert(calc.div(10, 0).isLeft)
      assert(calc.div(0, 0).isLeft)
      assert(calc.div(-10, 0).isLeft)
    }

    it("割れる") {
      assert(calc.div(30, 10).right.value == 3)
      assert(calc.div(3, 10).right.value == 0.3)
      assert(calc.div(-30, 10).right.value == -3)
    }
  }

  describe("isPrime") {
    it("その値が素数であるかどうかのブール値を返す") {
      assert(!calc.isPrime(0))
      assert(!calc.isPrime(-1))
      assert(calc.isPrime(2))
      assert(calc.isPrime(17))
    }

    it("1000万以下の値の素数判定を一秒以内で処理できる") {
      failAfter(1000 millis) {
        assert(calc.isPrime(9999991))
      }
    }
  }

  describe("Calcのモックオブジェクト") {
    it("振る舞いを偽装することができる") {
      val mockCalc = mock[Calc]
      when(mockCalc.sum(Seq(3, 4, 5))).thenReturn(12)
      assert(mockCalc.sum(Seq(3, 4, 5)) === 12)
    }
  }
}
