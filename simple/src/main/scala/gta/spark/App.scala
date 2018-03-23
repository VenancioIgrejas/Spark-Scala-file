package gta.spark

/**
 * @author ${user.name}
 */

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

object App {

  def main(args : Array[String]) {
   val sc: SparkContext = new SparkContext("local[4]","exemplo")
   val NUM_SAMPLES = 1000000
   val count = sc.parallelize(1 to NUM_SAMPLES).filter { _ =>
    val x = math.random
    val y = math.random
    x*x + y*y < 1
   }.count()
   println(s"Pi is roughly ${4.0 * count / NUM_SAMPLES}")
  }

}
