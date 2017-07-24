package com.kip.knoldus

import java.io.File

import org.scalatest.FunSuite

/**
  * Created by knoldus on 23/7/17.
  */
class WordCountTest extends FunSuite {

  test("testing count words method"){
    val dir: File = new File("/home/knoldus/IdeaProjects/scala03_assignment/documents/read2")
    assert(new WordCount().countingWords(dir) == List(true))
  }

}
