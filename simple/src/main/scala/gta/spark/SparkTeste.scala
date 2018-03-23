package gta.spark

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._


object SparkTeste {
  val sc: SparkContext = new SparkContext("local[4]","teste")
  
  def main(args: Array[String]){
  	println("cheguei até aqui")
  }
}
