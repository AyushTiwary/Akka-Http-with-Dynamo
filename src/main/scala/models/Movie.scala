package models

import java.util

import com.amazonaws.services.dynamodbv2.document.Table
import com.amazonaws.services.dynamodbv2.model._
import models.DBClient._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class Movie {

  def createTable(tableName: String): Future[Table] = Future {
    println("Attempting to create table, please wait....")
    dynamoDB.createTable(tableName,
      util.Arrays.asList(new KeySchemaElement("year", KeyType.HASH), // Partition key
        new KeySchemaElement("title", KeyType.RANGE)), // Sort key
      util.Arrays.asList(new AttributeDefinition("year", ScalarAttributeType.N),
        new AttributeDefinition("title", ScalarAttributeType.S)),
      new ProvisionedThroughput(10L, 10L))

  }.recoverWith {
    case ex => println("Unable to create the table")
      Future.failed(new Exception(ex.getMessage))
  }
}
