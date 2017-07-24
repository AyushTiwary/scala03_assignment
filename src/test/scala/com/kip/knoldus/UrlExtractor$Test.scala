package com.kip.knoldus

import org.scalatest.FunSuite

/**
  * Created by knoldus on 23/7/17.
  */
class UrlExtractor$Test extends FunSuite {

  test("testing parse URL method with correct input"){
    assert(new UrlParsing().parseUrl("https://www.google.co.in/?gfe_rd=ce&dss=dc") == "Protocol -> https\nHost -> google\nDomain -> co.in\nQuery Parameter -> Map(gfe_rd -> ce, dss -> dc)\n")
  }


}
