package com.swd.application.port.aws;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

public interface IDynamoDbFactory {
    DynamoDB getDynamoDBClient();
    AmazonDynamoDB getAmazonDynamoDBClient();
}
