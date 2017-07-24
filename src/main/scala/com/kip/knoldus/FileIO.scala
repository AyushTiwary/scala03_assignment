package com.kip.knoldus

import java.io.{File, PrintWriter}



/**
  * Created by knoldus on 21/7/17.
  */

trait FileIo{



  def readFromDir(dir : File): List[File] = {

    val listOfLies = dir.listFiles.toList

    checkExtension(listOfLies)

  }

  def checkExtension(list: List[File]): List[File] = {
    //val list1 = new File("/home/knoldus/IdeaProjects/scala03_assignment/documents/read").listFiles.toList
    val extn = List(".txt", ".logs", ".scala")
    extn.flatMap(e => list.filter(_.getName.contains(e)))

  }

  def writeToDir( readFile  : File, WriteDir : File, output : String) = {

    try{
      new PrintWriter(WriteDir.getAbsoluteFile + "/" + readFile.getName) {
        write(output)
        close()
      }
      true
    }
    catch {
      case e: Exception => false
    }
  }

  def createDirectory(dirName: String): File= {

    val dir: File = new File(dirName)

    if (!dir.exists)
    {
      val successful = dir.mkdir
      if (successful) { // creating the directory succeeded
        println("!!")
        dir
      }

      else
      { // creating the directory failed
        throw new Exception("failed trying to create the directory")
      }

    }

    else { // creating the directory failed

      throw new Exception("Directory already exists")

    }
  }

}

/*

  def createFile(filePath: String): File = new File(filePath)

  def readFile(filePath: String): Iterator[String] = Source.fromFile(createFile(filePath)).getLines

  def writeFile(file: File, text: String): File = {

*/
