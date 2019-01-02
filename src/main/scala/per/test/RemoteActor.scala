package per.test

import akka.actor.Actor

class RemoteActor extends Actor {
  override def receive: Receive = {
    case msg:String=>
      println(s"RemoteActor received message '$msg'")
      sender ! "Hello from the RemoteActor"
  }
}
