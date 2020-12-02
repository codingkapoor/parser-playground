package com.iamsmkr.simplearithmeticparser

import fastparse._

object Parser {
  implicit val ws: P[_] => P[Unit] = { implicit ctx: ParsingRun[_] =>
    CharsWhileIn(" ", 0)
  }

  def num[_: P]: P[Unit] = P(CharIn("0-9").rep(1) ~ (CharIn(".") ~ CharIn("0-9").rep(1)).rep)

  def factor[_: P]: P[Unit] = P(num | "(" ~ expr ~ ")")

  def term1[_: P]: P[Unit] = P((CharIn("*/") ~/ factor).rep)

  def term[_: P]: P[Unit] = P(factor ~ term1)

  def expr1[_: P]: P[Unit] = P((CharIn("+\\-") ~/ term).rep)

  def expr[_: P]: P[Unit] = P(term ~ expr1 ~ End)

}
