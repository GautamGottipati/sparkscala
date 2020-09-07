package practice

import java.io.File
import java.nio.file.{Files, Paths}
import java.time.temporal.ChronoUnit.DAYS
import java.time.Instant

import org.joda.time.Days

object FileSearchOlderThan7Days extends App {
  def getListOfFiles(dir: String, extension:List[String]):List[File] = {
    val d = new File(dir)
    if(d.exists && d.isDirectory){
      d.listFiles.filter(_.isFile).toList.filter{
        file=>extension.exists(file.getName.endsWith(_))
      }
    }else{
      List[File]()
    }
  }

  val fileExtensions = List(".txt")
  val files = getListOfFiles("G:\\courses\\testing",fileExtensions)
  for( i<- files){
    println(i)
    val path = Paths.get("G:\\courses\\testing")
//    val filePath = os.Path
    val mdate = Files.getLastModifiedTime(path)
    println(s"Your modified date is ${mdate}")

    val modifiedInstant = mdate.toInstant()
    val trackDays = 5
    val isMoreThanNDaysOld = modifiedInstant.plus(trackDays,DAYS).isBefore(Instant.now())
    if(!isMoreThanNDaysOld){
      println(s"This file is not ${trackDays} days old");
    }else{
      println(s"This file is  ${trackDays} days old");
    }

  }

}
