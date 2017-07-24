package com.kip.knoldus

import java.io.File

import org.scalatest.FunSuite

/**
  * Created by knoldus on 24/7/17.
  */
class UpperTest extends FunSuite {


  test("testing upper case method"){
    val dir: File = new File("/home/knoldus/IdeaProjects/scala03_assignment/documents/read")
    assert(new Upper().uppercaseTask(dir) == List(true, true))
  }

  test("testing write output method"){
    val sourceFile = new File("/home/knoldus/IdeaProjects/scala03_assignment/documents/read/url.txt")
    val destDir = new File("/home/knoldus/IdeaProjects/scala03_assignment/documents/write")

    assert(new Upper().capitalText(sourceFile,destDir) == true)

}
