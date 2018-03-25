package gta.spark

/*
 command in terminal:
 sudo /opt/Spark/spark-2.3.0-bin-hadoop2.7/bin/spark-submit \
 --class gta.spark.App simple-1.0-SNAPSHOT.jar <file>
*/
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.DataFrame
import org.apache.spark.rdd.RDD

object  Dataset {
  val numberFeacture = 46
  val master = "spark://master:7077"

  val conf: SparkConf = new SparkConf().setMaster(master).setAppName("CATRACA")
  val sc: SparkContext = new SparkContext(conf)

  def dataPreparing(lines: RDD[String]) = {
    val virgulas = lines.map(x => x.split(',')).

  }

  def main(args: Array[String]){
    val inputPath = args(0)
    val (vactor,classes) = dataPreparing(sc.textFile(inputPath))

    println(inputPath)
    sc.stop()
  }
}
