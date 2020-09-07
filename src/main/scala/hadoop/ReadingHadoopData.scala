package hadoop

import org.apache.spark.sql.{SaveMode, SparkSession}

object ReadingHadoopData extends  App{
  val spark = SparkSession.builder()
    .appName("HDFSReading")
    .config("spark.master","local")
    .getOrCreate()

  val df = spark.read.text("hdfs://localhost:9000/TestFolder/sample.txt")

  df.show()
  df.write
    .format("csv")
    .option("header","true")
    .mode(SaveMode.Overwrite)
    .save("G:\\sparkscala\\src\\main\\resources\\data\\sample.csv")

}
