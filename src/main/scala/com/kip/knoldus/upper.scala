package com.kip.knoldus
import java.io.{FileNotFoundException, File}
import scala.io.Source


/**
  * Created by knoldus on 21/7/17.
  */

class Upper extends FileIo{

  def capitalText(source : File , writeDir : File) : Boolean = {

    val boolean: Boolean = writeToDir(source, writeDir, Source.fromFile(source).getLines.mkString("\n").toUpperCase)
    boolean

  }

  def uppercaseTask(directory: File): List[Boolean] = {

    val files: List[File] = readFromDir(directory)

    val newDirectoryName = directory.getAbsolutePath + "_new"
    val destDirectory: File = createDirectory(newDirectoryName)

    if(!files.isEmpty) {

      val booleanList: List[Boolean] =

        for{file <- files
            result = capitalText(file,destDirectory)
           } yield result

      booleanList

    }
    else {
      throw new FileNotFoundException
    }
  }

}