package com.iamsmkr.simplearithmeticparser

import com.iamsmkr.simplearithmeticparser.Parser._
import fastparse._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class ParserSpec extends AnyFlatSpec with Matchers {

  "Decimal Number parser" should "parse any decimal number" in {
    val Parsed.Success(value, successIndex) = parse("9.4", expr(_))

    value shouldBe()
    successIndex shouldBe 3

    val Parsed.Success(value1, successIndex1) = parse("0.0", expr(_))

    value1 shouldBe()
    successIndex1 shouldBe 3

    val Parsed.Success(value3, successIndex3) = parse("9", expr(_))

    value3 shouldBe()
    successIndex3 shouldBe 1
  }

  "Number parser" should "parse number expressions that has only numbers" in {
    val Parsed.Success(value, successIndex) = parse("9 * 2 + 1 - 10", expr(_))

    value shouldBe()
    successIndex shouldBe 14
  }

}
