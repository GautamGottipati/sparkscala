package practice

import java.io.File
import java.nio.file.attribute.FileTime
import java.nio.file.{Files, Path, Paths}

import scala.collection.immutable.HashMap
import scala.collection.mutable

class Store(var path: String) {

  def display() = {
    println(s"You have entered ${path}")
    val myDir = new File(path)

    if (myDir.exists && myDir.isDirectory) {
      val files = myDir.listFiles
      println(s"Here are your files ${files}")
      var hashMap = new HashMap[String,FileTime]()
      for(f <- files){
          println(f.getCanonicalPath())
          val myPath = f.getCanonicalPath()
          val modDate = Files.getLastModifiedTime(Paths.get(myPath))
          hashMap = hashMap + (myPath -> modDate)




      }

      hashMap

    }
  }
}


object FileDirectory extends App {
  var path = "G:\\courses\\testing"
  var myObj = new Store(path)
  var myResult = myObj.display()
  println(myResult)


}
