package com.kip.knoldus

import java.io.{FileNotFoundException, PrintWriter, File}
import java.net.URL

import scala.io.Source

/**
  * Created by knoldus on 21/7/17.
  */
object UrlExtractor {

  def unapply(url: URL): Option[(String, String, String, Map[String, String])] = {

    //val url : URL = new URL(urls)

    val protocol = url.getProtocol

    val address = url.getHost

    val addressWithoutWww = if (address.startsWith("www.")) {

      address.substring(4)

    }

    else {

      address

    }

    val regex101 = "[a-z]+\\.([a-z]+)\\.(.*)".r

    val regex101(host, domain) = addressWithoutWww

/*
    val host = address.split(".")

    val domain = addressWithoutWww.split(".")(1)
*/

    val query = url.getQuery

   val params =
     if (query == null)
     {

       Map[String, String]()

     }

    else
    {

      query.split("&").map(param => (param.split("=")(0) -> param.split("=")(1))).toMap

    }

    Some((protocol, host, domain, params))

  }

  /*= {

      if(urlLeft.length > 0){



      }

      else {

        Map()

      }

    }

    Some(protocol, host, domain, params)

  }
}*/


}


class UrlParsing extends FileIo{

  def parseUrl(url : String): String = {

    new URL(url) match{

      case UrlExtractor(protocol, host, domain, queryParams) => s"Protocol : $protocol \n Host : $host \n Domain :" +
        s" $domain \n Query-Params : $queryParams"

      case _ => "Cannot be Parsed"

    }

  }

  def readWriteFile(sourceFile: File): Boolean ={

    try
    {
      val list: List[File] = checkExtension(List(sourceFile))

      val file = list(0)

      if (list.isEmpty)
      {
        throw new FileNotFoundException("File is not readable")

      }
      else {

        val fileContent = Source.fromFile(file).getLines.mkString("\n")

        val fileContentArray: Array[String] = fileContent.split("\n")

        val fileOutput: Array[String] =

          for {line <- fileContentArray
               output = parseUrl(line)
               } yield output

        //writing to new file
        new PrintWriter("Output_" + file.getName)
        {

          write(fileOutput.mkString)
          close

        }

        true

      }

    }

    catch
      {
         case e: Exception =>false
      }
  }
}
