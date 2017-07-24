package com.kip.knoldus

import java.io.{FileNotFoundException, File}

/**
  * Created by knoldus on 22/7/17.
  */
class WordCount extends  FileIo {

  def count(readFile: File, writeDir: File): Boolean = {

    val wordCount = scala.io.Source.fromFile("file").getLines.flatMap(_.split("\\W+"))
      .foldLeft(Map.empty[String, Int]) {
        (count, word) => count + (word -> (count.getOrElse(word, 0) + 1))
      }

    val wordCountString = wordCount.toList.toString

    writeToDir(readFile, writeDir, wordCountString)

  }


  def countingWords(directory: File): List[Boolean] = {

    val files: List[File] = readFromDir(directory)

    val newDirectoryName = directory.getAbsolutePath + "_new"
    val newDirectory: File = createDirectory(newDirectoryName)

    if (!files.isEmpty) {
      val booleanList: List[Boolean] =

        for {file <- files
             result = count(file, newDirectory)
        } yield result

      booleanList

    }
    else {
      throw new FileNotFoundException
    }

  }

}