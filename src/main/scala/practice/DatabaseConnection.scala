package practice

import java.sql.DriverManager
import java.sql.Connection
import java.sql.ResultSet
import java.util.Properties

import org.apache.spark.sql.{SaveMode, SparkSession}
import practice.InnerJoin.spark

object DatabaseConnection extends App {

//  Setting up spark instance
  val spark = SparkSession.builder()
    .appName("Joins")
    .config("spark.master","local")
    .getOrCreate()

//  JDBC credentials
  val driver = "com.mysql.jdbc.Driver"
  val url = "jdbc:mysql://localhost:3306/bank?autoReconnect=true&useSSL=false"
  val username = "root"
  val password = "Mysql@123"
  val table = "customer"

//  Reading csv file
  val customersDF = spark.read
    .format("csv")
    .option("header","true")
    .load("src/main/resources/data/customers.csv")

  val properties = new Properties()
  properties.put("user",username)
  properties.put("password",password)
  Class.forName(driver)

//  Writing the csv file to mysql database
  customersDF.write
    .mode(SaveMode.Overwrite)
    .jdbc(url,"test",properties)


}
