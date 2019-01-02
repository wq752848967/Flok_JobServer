package per.test

import akka.actor.Actor
import org.apache.spark.sql.SparkSession

case class Start()
case class ReadFile(inputPath:String,outputPath:String)
case class End()
class JobManagerActor(spark: SparkSession) extends Actor{
  private val sparkSession:SparkSession = spark;
  override def receive: Receive = {
      case Start=>{
       println("JobManagerActor: i  am start")
      }
      case ReadFile(inputPath,outputPath)=>{
        val ds = sparkSession.read.csv(inputPath)
        ds.write.csv(outputPath)
        sender()!"file write ok!"
      }
      case  End=>{
        context.stop(self)
      }


  }
}
