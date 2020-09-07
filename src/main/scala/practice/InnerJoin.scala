package practice

import org.apache.spark.sql.SparkSession

object InnerJoin extends App {
//  Create a spark session
  val spark = SparkSession.builder()
    .appName("Joins")
    .config("spark.master","local")
    .getOrCreate()

  val customersDF = spark.read
    .format("csv")
    .option("header","true")
    .load("src/main/resources/data/customers.csv")

  customersDF.show()

  val ordersDF = spark.read
    .format("csv")
    .option("header","true")
    .load("src/main/resources/data/orders.csv")

  ordersDF.show()

  //  joins
  val ordersJoins = ordersDF.join(customersDF,ordersDF.col("CUSTOMER_ID")===customersDF.col("id"),"inner")

  ordersJoins.show()


}
