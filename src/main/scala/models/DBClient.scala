package models

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient
import com.amazonaws.services.dynamodbv2.document.DynamoDB

object DBClient {
  val client = new AmazonDynamoDBClient(new DefaultAWSCredentialsProviderChain())
  val dynamoDB = new DynamoDB(client)
}
