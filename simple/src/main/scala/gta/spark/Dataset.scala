package gta.spark

/*
 command in terminal:
 sudo /opt/Spark/spark-2.3.0-bin-hadoop2.7/bin/spark-submit \
 --class gta.spark.App simple-1.0-SNAPSHOT.jar
*/
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.sql.SparkSession

object  Dataset {
/*  val spark: SparkSession = new SparkSession.builder()
  .master("local[4]")
  .appName("Output teste")
  .getOrCreate()
*/
  def main(args: Array[String]){
    val conf: SparkConf = new SparkConf().setMaster("local[4]").setAppName("exemplo")
    val sc: SparkContext = new SparkContext(conf)

    val inputPath = args(0)
    println(inputPath)
  }
}
