package sample

import org.apache.spark.sql.SparkSession

object ReadingJson extends App {

  //  creating a spark session
  val spark = SparkSession.builder()
    .appName("DataFrame basics")
    .config("spark.master","local")
    .getOrCreate()

//  reading a DF
  val firstDF = spark.read
    .format("json")
    .option("inferSchema","true")
    .load("src/main/resources/data/cars.json")

  firstDF.show()
  firstDF.printSchema()
}
