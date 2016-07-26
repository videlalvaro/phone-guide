package org.videlalvaro.phoneguide.generators

import org.scalacheck.{Arbitrary, Gen}
import org.videlalvaro.phoneguide.PhoneNumber

object Generators {

  implicit val arbPhoneNumber: Arbitrary[PhoneNumber] = Arbitrary(genPhoneNumber)

  def genPhoneNumber = for {
    areaCode <- Gen.choose(1, 999)
    prefix <- Gen.choose(1, 999)
    lineNumber <- Gen.choose(1, 9999)
  } yield new PhoneNumber(areaCode, prefix, lineNumber)

}
