package per.test

import akka.actor.{ActorSystem, Props}
import org.apache.spark.sql.SparkSession

object SparkJobServer {
  def main(args: Array[String]): Unit = {
    val  actor_sys = ActorSystem("SparkJobServer")
    val  sparkSession = SparkSession.builder().appName("SparkJobServer").getOrCreate()
    val  jobManager = actor_sys.actorOf(Props(new JobManagerActor(sparkSession)),"JobManagerActor")
    actor_sys.registerOnTermination(System.exit(0))
  }

}
