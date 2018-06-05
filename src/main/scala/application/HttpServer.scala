package application

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._

object HttpServer extends App with WelcomeApi with MovieApi {
  implicit val system: ActorSystem = ActorSystem("user-routes")
  val port = 8080

  Http().bindAndHandle(movieRoutes ~ singletoneRoute, "localhost", port)
  println(s" ********** Akka_Http_Server is started on port ********** $port")
}
