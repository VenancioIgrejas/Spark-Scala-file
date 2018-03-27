package gta.spark

/*
 command in terminal:
 sudo /opt/Spark/spark-2.3.0-bin-hadoop2.7/bin/spark-submit \
 --class gta.spark.App simple-1.0-SNAPSHOT.jar <file>
*/
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
//import org.apache.spark.sql.SparkSession
//import org.apache.spark.sql.DataFrame
import org.apache.spark.rdd.RDD
//import scala.collection.mutable.ArrayBuffer


object  Dataset {
  val numberFeacture = 46
  val master = "spark://master:7077"

  val conf: SparkConf = new SparkConf().setMaster(master).setAppName("CATRACA")
  val sc: SparkContext = new SparkContext(conf)
/*
  def inputMatriz(rddMatriz: Any) = {
    for (i <- 0 to 3){
      rddMatriz.remove(i)
    }
    rddMatriz
  }
*/
  def dataPreparing(lines: RDD[String]) = {
    val virgulas = lines.map(_.split(',').toBuffer).map(x => {
      for(i <- 0 to 3){
        x.remove(0)
      }
      x
    })
    val classes = virgulas.map(x => x(x.length -1))
    val test = virgulas.map(x => x - x(x.length -1))
    (test,classes)
  }

  def main(args: Array[String]){
    val inputPath = args(0)
    val (vector,classes) = dataPreparing(sc.textFile(inputPath))
    println(vector.take(1))
    println(classes.take(1))
    sc.stop()
  }
}
