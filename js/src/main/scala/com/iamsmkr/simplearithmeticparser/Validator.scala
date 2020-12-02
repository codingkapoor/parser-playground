package com.iamsmkr.simplearithmeticparser

import com.iamsmkr.simplearithmeticparser.Parser._
import org.scalajs.dom
import org.scalajs.dom._
import fastparse._
import org.scalajs.dom.html.TextArea

object Validator {

  def main(args: Array[String]): Unit = simpleArithmeticParser()

  def simpleArithmeticParser(): Unit = {
    val editor = document.getElementById("editor").asInstanceOf[TextArea]
    val results = document.getElementById("results").asInstanceOf[TextArea]

    def reparse(newValue: String, parser: P[_] => P[Any] = expr(_)): Unit = {
      parse(newValue, parser) match {
        case s: fastparse.Parsed.Success[_] =>
          results.value = "Parsed Successfully!"

        case fastparse.Parsed.Failure(_, index, extra) =>
          val pretty = literalize(extra.input.slice(index, index + 15))
          results.value =
            s"""Failure at index: $index
               |Found: $pretty
               |Expected: ${extra.trace().label}
            """.stripMargin
      }
    }

    editor.addEventListener("input", { (e: dom.Event) =>
      if (editor.value.isEmpty) results.value = ""
      else reparse(editor.value)
    })
  }
}
