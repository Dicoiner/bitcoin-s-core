package org.bitcoins.core.number

import org.scalatest.{FlatSpec, MustMatchers}

/**
  * Created by chris on 6/14/16.
  */
class UInt32Test extends FlatSpec with MustMatchers {

  "UInt32" must "create the number zero as an unsigned 32 bit integer" in {
    val zero = UInt32(Seq(0x0.toByte))
    zero.underlying must be (0)
  }

  it must "create the max number for an unsigned byte" in {
    val maxByteValue = UInt32(Seq(0xff.toByte))
    maxByteValue.underlying must be (255)
  }


  it must "create the number 256" in {
    val uInt32 = UInt32(Seq(0x01.toByte, 0x00.toByte))
    uInt32.underlying must be (256)
  }

  it must "create the number 65535" in {
    val uInt32 = UInt32(Seq(0xff.toByte, 0xff.toByte))
    uInt32.underlying must be (65535)
  }

  it must "create the number 65536" in {
    val uInt32 = UInt32(Seq(0x01.toByte, 0x0.toByte, 0x0.toByte))
    uInt32.underlying must be (65536)
  }

  it must "create the number 16777215" in {
    val uInt32 = UInt32(Seq(0xff.toByte, 0xff.toByte, 0xff.toByte))
    uInt32.underlying must be (16777215)
  }

  it must "create the number 16777216" in {
    val uInt32 = UInt32(Seq(1.toByte, 0.toByte, 0.toByte, 0.toByte))
    uInt32.underlying must be (16777216)
  }

  it must "create the number 4294967295" in {
    //this is UInt32_t's max value
    val uInt32 = UInt32(Seq(0xff.toByte, 0xff.toByte, 0xff.toByte, 0xff.toByte))
    uInt32.underlying must be (4294967295L)
    uInt32.hex must be ("ffffffff")
  }

  it must "throw an exception if we try and create a UInt32 with a negative number" in {
    intercept[IllegalArgumentException] {
      UInt32(-1)
    }
  }

  it must "have the correct representation for 0" in {
    UInt32.zero.underlying must be (0)
  }

  it must "have the correct representation for 1" in {
    UInt32.one.underlying must be (1)
  }

  it must "have the correct minimum number for a UInt32" in {
    UInt32.min.underlying must be (0)
  }

  it must "have the correct maximum number representation for UInt32" in {
    UInt32.max.underlying must be (4294967295L)
    UInt32.max.hex must be ("ffffffff")
  }
}
