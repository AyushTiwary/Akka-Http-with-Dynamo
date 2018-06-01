package application

import akka.http.javadsl.model.{ContentTypes, HttpEntities}
import akka.http.scaladsl.model.HttpResponse
import akka.http.scaladsl.model.StatusCodes.{BadRequest, InternalServerError, OK}
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
          .create(ContentTypes.APPLICATION_JSON, "Invalid Json Field")))
  }

  def handleTableCreationRequest(tableReq: Table): Future[HttpResponse] = {

    val newTable = movie.createTable(tableReq.name)
    newTable.map {
      _ =>
        HttpResponse(OK,
          entity = HttpEntities.create(ContentTypes.APPLICATION_JSON, ByteString("Okay")))
    }.recoverWith {
      case _: Exception =>
        Future.successful(HttpResponse(InternalServerError,
          entity = HttpEntities.create(ContentTypes.APPLICATION_JSON, "INTERNAL_SERVER_ERROR")))
    }
  }
}
