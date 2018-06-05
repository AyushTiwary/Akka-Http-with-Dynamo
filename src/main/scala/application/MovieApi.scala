package application

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

case class Table(name: String)

trait MovieApi extends JsonHelper{
  val movieApiHelper = new MovieApiHelper

  val movieRoutes: Route = create ~ delete

  def create: Route = {
    path("movie" / "create") {
      post {
        entity(as[Table]) { table =>
          if (table.name.isEmpty) {
            complete(movieApiHelper.invalidTableJson(table))
          }
          else {
            complete(movieApiHelper.handleTableCreationRequest(table))
          }

        }
      }
    }
  }

  def delete: Route = ???
}
