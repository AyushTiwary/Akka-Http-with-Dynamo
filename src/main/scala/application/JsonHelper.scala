package application

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.DefaultJsonProtocol

trait JsonHelper extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val tableFormat = jsonFormat1(Table) // contains List[Item]
}


