package models

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.regions.Regions
import com.amazonaws.services.dynamodbv2.{AmazonDynamoDBClient, AmazonDynamoDBClientBuilder}
import com.amazonaws.services.dynamodbv2.document.DynamoDB

object DBClient {

  val client = AmazonDynamoDBClientBuilder.standard()
    .withRegion(Regions.DEFAULT_REGION)
    //.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "DEFAULT_REGION"))
    .build()

  val dynamoDB = new DynamoDB(client)
}
