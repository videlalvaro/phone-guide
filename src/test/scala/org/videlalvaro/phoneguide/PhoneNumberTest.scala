package org.videlalvaro.phoneguide

import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}
import org.videlalvaro.phoneguide.generators.Generators._


/**
  * See the properties that equals should satisfy on Item 9 from Effective Java.
  */
class PhoneNumberTest extends FunSuite with GeneratorDrivenPropertyChecks with Matchers {

  test("equals should be reflexive") {
    forAll { (phoneNumber: PhoneNumber) =>
      phoneNumber.equals(phoneNumber) should be (true)
    }
  }

  test("equals should be symmetric") {
    forAll { (phoneNumber: PhoneNumber) =>
      val phoneNumber2 = PhoneNumber.fromPhoneNumber(phoneNumber)
      phoneNumber.equals(phoneNumber2) should be (true)
      phoneNumber2.equals(phoneNumber) should be (true)
    }
  }

  test("equals should be transitive") {
    forAll { (phoneNumber: PhoneNumber) =>
      val phoneNumber2 = PhoneNumber.fromPhoneNumber(phoneNumber)
      val phoneNumber3 = PhoneNumber.fromPhoneNumber(phoneNumber2)
      phoneNumber.equals(phoneNumber2) should be (true)
      phoneNumber.equals(phoneNumber3) should be (true)
      phoneNumber2.equals(phoneNumber) should be (true)
      phoneNumber2.equals(phoneNumber3) should be (true)
      phoneNumber3.equals(phoneNumber) should be (true)
      phoneNumber3.equals(phoneNumber2) should be (true)
    }
  }

  test("equals should be consistent") {
    forAll { (phoneNumber: PhoneNumber) =>
      val phoneNumber2 = PhoneNumber.fromPhoneNumber(phoneNumber)
      phoneNumber.equals(phoneNumber2) should be (true)
      phoneNumber.equals(phoneNumber2) should be (true)
      phoneNumber2.equals(phoneNumber) should be (true)
      phoneNumber2.equals(phoneNumber) should be (true)
    }
  }

  test("equals should respect non-nullity") {
    forAll { (phoneNumber: PhoneNumber) =>
      phoneNumber.equals(null) should be (false)
    }
  }
}
