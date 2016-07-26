package org.videlalvaro.phoneguide.netty

import io.netty.channel.embedded.EmbeddedChannel
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}
import org.videlalvaro.phoneguide.PhoneNumber
import org.videlalvaro.phoneguide.generators.Generators._

class EncoderDecoderTest extends FunSuite with GeneratorDrivenPropertyChecks with Matchers {
  test("netty encode/decode message") {
    forAll { (phoneNumber: PhoneNumber) =>
      val channel = new EmbeddedChannel(new MessageEncoder(), new MessageDecoder())

      channel.writeOutbound(phoneNumber)
      channel.writeInbound(channel.readOutbound())

      val readPhoneNumber = channel.readInbound();
      readPhoneNumber should not be (null)
      readPhoneNumber.equals(phoneNumber) should be (true)
      phoneNumber.equals(readPhoneNumber) should be (true)
    }
  }
}