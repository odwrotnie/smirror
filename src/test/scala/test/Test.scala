package test

import scala.reflect.runtime.universe._
import net.fwbrasil.smirror._
import org.scalatest.FunSuite

/*
sbt "~testOnly test.Test"
 */

case class Person(name: String)
object Person

class Test
  extends FunSuite {

  implicit val runtimeMirror = scala.reflect.runtime.universe.runtimeMirror(getClass.getClassLoader)

  test("One") {
    val jClass = runtimeMirror.runtimeClass(typeOf[Person]).asInstanceOf[Class[Person]]
    println("Person jClass: " + jClass)
    val sClass = sClassOf[Person]
    println("Person sClass: " + sClass)
    val companion = sClass.companionObjectOption.get.instance
    println("Companion: " + companion)
  }
}
