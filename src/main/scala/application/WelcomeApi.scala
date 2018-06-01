package application

import akka.actor.ActorSystem
import akka.http.scaladsl.model.{HttpResponse, StatusCodes}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer

trait WelcomeApi {
  implicit val system: ActorSystem
  lazy implicit val executor = system.dispatcher
  lazy implicit val materializer = ActorMaterializer()

  val singletoneRoute: Route = pathSingleSlash {
    get {
      complete {
        HttpResponse(StatusCodes.OK, entity = "Welcome......!!|")
      }
    } ~
      post {
        complete {
          HttpResponse(StatusCodes.OK, entity = "Welcome......!!")
        }
      }
  }
}
