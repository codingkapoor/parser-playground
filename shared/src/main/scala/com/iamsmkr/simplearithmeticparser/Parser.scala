package com.iamsmkr.simplearithmeticparser

import fastparse._

object Parser {
  implicit val ws: P[_] => P[Unit] = { implicit ctx: ParsingRun[_] =>
    CharsWhileIn(" ", 0)
  }

  def fp[_: P]: P[Unit] = P(CharIn("0-9").rep(1) ~ (CharIn(".") ~ CharIn("0-9").rep(1)).rep)

  def num2[_: P]: P[Unit] = P("(" ~ num ~ ")" | fp)

  def num1[_: P]: P[Unit] = P(num2 ~ (CharIn("*/") ~/ num2).rep)

  def num[_: P]: P[Unit] = P(num1 ~ (CharIn("+\\-") ~/ num1).rep ~ End)

}
