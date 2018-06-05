package application

import akka.http.javadsl.model.HttpEntities
import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.model.{ContentTypes, _}
import akka.util.ByteString
import models.Movie

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class MovieApiHelper {
  val movie = new Movie

  def invalidTableJson(tableReq: Table): Future[HttpResponse] = {
    Future
      .successful(HttpResponse(BadRequest,
        entity = HttpEntities
          .create(ContentTypes.`application/json`, "Invalid Json Field")))
  }

  def handleTableCreationRequest(tableReq: Table): Future[HttpResponse] = {

    val newTable = movie.createTable(tableReq.name)
    newTable.map {
      _ =>
        println("Okay request")
        HttpResponse(OK, entity = ByteString("Table has been created"))
    }.recoverWith {
      case _: Exception =>
        println("in exception....!!!!")
        Future.successful(HttpResponse(InternalServerError, entity = ByteString("INTERNAL_SERVER_ERROR")))
    }
  }
}
