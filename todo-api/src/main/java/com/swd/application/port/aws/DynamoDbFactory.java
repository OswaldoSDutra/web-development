package com.swd.application.port.aws;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.google.inject.Inject;
import com.swd.application.config.IAppConfig;

public class DynamoDbFactory implements IDynamoDbFactory{

    private AmazonDynamoDB amazonDynamoDB;
    private DynamoDB dynamoDb;

    private String endpoint;
    private String region;

    @Inject
    public DynamoDbFactory(IAppConfig config) {
        this.endpoint = config.getDbHost();
        this.region = config.getAwsRegion();
    }

    public AmazonDynamoDB getAmazonDynamoDBClient(){

        if(this.amazonDynamoDB == null){
            AwsClientBuilder.EndpointConfiguration endpointConfiguration = new
                    AwsClientBuilder.EndpointConfiguration(this.endpoint, this.region);

            this.amazonDynamoDB = AmazonDynamoDBClientBuilder
                    .standard()
                    .withEndpointConfiguration(endpointConfiguration)
                    .build();
        }

        return this.amazonDynamoDB;
    }

    public DynamoDB getDynamoDBClient(){

        if(this.dynamoDb == null){
            this.dynamoDb = new DynamoDB(this.getAmazonDynamoDBClient());
        }

        return this.dynamoDb;
    }

}
